package edu.suse.bookstore.controller;

import edu.suse.bookstore.service.OrderService;
import edu.suse.bookstore.common.utils.JsonMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String orderListPage(ModelMap map){
        map.put("page","order/order-list.html");
        return "system-index";
    }

    @GetMapping("/deliver")
    public String orderDeliverPage(ModelMap map){
        map.put("page","order/order-deliver.html");
        return "system-index";
    }

    @PostMapping("/deliver-end")
    @ResponseBody
    public Object endOrderDeliver(@RequestParam("orderNumber") String orderNumber){
        return new JsonMap(orderService.processOrder(orderNumber)).end();
    }

    @GetMapping("/list")
    @ResponseBody
    public Object orderList(@RequestParam("keyword") String keyword){
        return new JsonMap(orderService.orderList(keyword)).end();
    }

    @GetMapping("/deliver-data")
    @ResponseBody
    public Object orderDeliverList(@RequestParam("keyword") String keyword){
        return new JsonMap(orderService.orderDeliverList(keyword)).end();
    }



}
