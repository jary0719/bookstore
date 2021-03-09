package edu.suse.bookstore.service;

import edu.suse.bookstore.domain.Order;
import edu.suse.bookstore.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    public List<Order> selectOrderWithImageByUserId(String userId) {
        return orderMapper.selectOrderWithImageByUserId(userId);
    }

    public List<Order> orderList( String keyword) {
        List<Order> order = orderMapper.selectOrderByKeyword("%"+keyword+"%",null,null);
        return order;
    }

    public List<Order> orderDeliverList(String keyword) {
        List<Order> deliverOrder = new ArrayList<>();
        List<Order> Order = orderList(keyword);
        for (Order order : Order) {
            if (order.getStatus() == null || order.getStatus() == 0){
                deliverOrder.add(order);
            }
        }
        return deliverOrder;
    }

    public Object processOrder(String orderNumber) {
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setStatus(1);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public Object findOrderByUserId(String userId) {
        List<Order> order = orderMapper.selectOrderByKeyword("%%",userId,null);
        return order;
    }
}
