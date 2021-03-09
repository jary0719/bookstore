package edu.suse.bookstore.service;

import edu.suse.bookstore.domain.Order;
import edu.suse.bookstore.domain.OrderBook;
import edu.suse.bookstore.domain.ShopCart;
import edu.suse.bookstore.domain.ShopCartExample;
import edu.suse.bookstore.mapper.OrderBookMapper;
import edu.suse.bookstore.mapper.OrderMapper;
import edu.suse.bookstore.mapper.ShopCartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShopCartService {
    private final ShopCartMapper shopCartMapper;
    private final OrderMapper orderMapper;
    private final OrderBookMapper orderBookMapper;

    public ShopCartService(ShopCartMapper shopCartMapper, OrderMapper orderMapper, OrderBookMapper orderBookMapper) {
        this.shopCartMapper = shopCartMapper;
        this.orderMapper = orderMapper;
        this.orderBookMapper = orderBookMapper;
    }

    public List<ShopCart> selectCartByUserId(String userId) {
        return shopCartMapper.selectCartByUserId(userId);
    }

    public Integer editQuantity(Integer cartId, Integer quantity) {
        ShopCart cart = new ShopCart();
        cart.setCartId(cartId);
        cart.setQuantity(quantity);
        return shopCartMapper.updateByPrimaryKeySelective(cart);
    }

    public Integer addToCart(String userId, Integer bookId) {
        ShopCart cart = new ShopCart();
        cart.setBookId(bookId);
        cart.setUserId(userId);
        return shopCartMapper.insertSelective(cart);
    }

    public Object deleteCart(Integer cartId) {
        return shopCartMapper.deleteByPrimaryKey(cartId);
    }

    public List<ShopCart> selectByCartId(String cartIds) {
        List<Integer> cartIdList = new ArrayList<>();
        List<ShopCart> cartList = new ArrayList<>();
        for (String id : cartIds.split(",")) {
            cartIdList.add(Integer.parseInt(id));
        }
        return shopCartMapper.selectCartByCartIds(cartIdList);
    }

    public Object clearCart(String userId) {
        ShopCartExample example = new ShopCartExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return shopCartMapper.deleteByExample(example);
    }

    @Transactional
    public Order generateOrder(List<ShopCart> cartList) {
        Order order = new Order();
        order.setStatus(-1);
        order.setOrderTime(new Date());
        order.setUserId(cartList.get(0).getUserId());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        order.setOrderNumber("WSSDGWPT"+format.format(new Date()));
        orderMapper.insert(order);
        for (ShopCart cart : cartList) {
            OrderBook orderBook = new OrderBook();
            orderBook.setQuant(cart.getQuantity());
            orderBook.setBookId(cart.getBookId());
            orderBook.setOrderNumber(order.getOrderNumber());
            orderBookMapper.insert(orderBook);
            shopCartMapper.deleteByPrimaryKey(cart.getCartId());
        }
        return order;
    }

    public Object payOver(String orderNumber) {
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setStatus(0);
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
