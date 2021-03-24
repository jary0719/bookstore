package edu.suse.bookstore.controller;

import edu.suse.bookstore.domain.ShopCart;
import edu.suse.bookstore.service.OrderService;
import edu.suse.bookstore.service.ShopCartService;
import edu.suse.bookstore.common.utils.JsonMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShopCartController {

    private final ShopCartService shopCartService;
    private final OrderService orderService;

    public ShopCartController(ShopCartService shopCartService, OrderService orderService) {
        this.shopCartService = shopCartService;
        this.orderService = orderService;
    }

    @PostMapping("quantity")
    @ResponseBody
    public Integer editQuantity(@RequestParam("cartId")Integer cartId,@RequestParam("quantity") Integer quantity){
        return shopCartService.editQuantity(cartId,quantity);
    }

    @PostMapping("add")
    @ResponseBody
    public Object addCart(@RequestParam("userId")String userId,@RequestParam("bookId")Integer bookId){
        return shopCartService.addToCart(userId,bookId);
    }

    @DeleteMapping
    @ResponseBody
    public Object deleteCart(@RequestParam("cartId")Integer cartId){
        return shopCartService.deleteCart(cartId);
    }

    @PostMapping("to-pay")
    public String payPage(ModelMap map,@RequestParam("cartIds")String cartIds){
        List<ShopCart> cartList = shopCartService.selectByCartId(cartIds);
        map.put("page","/front-pages/pay.html");
        map.put("cartList",cartList);
        map.put("orderNumber",shopCartService.generateOrder(cartList).getOrderNumber());
        return "index";
    }

    @PostMapping("over")
    @ResponseBody
    public Object payOver(@RequestParam("orderNumber")String orderNumber){
        return shopCartService.payOver(orderNumber);
    }

    @PostMapping("/order")
    @ResponseBody
    public Object orderList(@RequestParam("userId")String userId){
        return new JsonMap(orderService.findOrderByUserId(userId)).end();
    }

    @PostMapping("/clear")
    @ResponseBody
    public Object clearCart(@RequestParam("userId")String userId){
        Object clearCart = shopCartService.clearCart(userId);
        return new JsonMap(clearCart).end();
    }
}
