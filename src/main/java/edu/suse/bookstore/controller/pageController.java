package edu.suse.bookstore.controller;

import edu.suse.bookstore.domain.Order;
import edu.suse.bookstore.service.BookService;
import edu.suse.bookstore.service.OrderService;
import edu.suse.bookstore.service.ShopCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/page")
public class pageController {
    private final BookService bookService;
    private final ShopCartService shopCartService;
    private final OrderService orderService;

    public pageController(BookService bookService, ShopCartService shopCartService, OrderService orderService) {
        this.bookService = bookService;
        this.shopCartService = shopCartService;
        this.orderService = orderService;
    }

    @GetMapping("/type")
    public String findByType(@RequestParam("typeId")Integer typeId, ModelMap map){
        map.put("bookList",bookService.selectByTypeAndKeyword(typeId,""));
        map.put("page","front-pages/view.html");
        return "index";
    }

    @GetMapping("/detail")
    public String bookDetails(@RequestParam("bookId")Integer bookId,ModelMap map){
        map.put("book",bookService.selectBookByIdWithImage(bookId));
        map.put("page","front-pages/bookinfo.html");
        return "index";
    }

    @GetMapping("/cart")
    public String shoppingCartPage(@RequestParam("userId")String userId,ModelMap map){
        map.put("cartBooks",shopCartService.selectCartByUserId(userId));
        map.put("page","front-pages/shop-cart.html");
        return "index";
    }

    @GetMapping("/order")
    public String orderPage(@RequestParam("userId")String userId, ModelMap map, HttpServletRequest request){
        List<Order> ordersList = orderService.selectOrderWithImageByUserId(userId);
        map.put("orders",ordersList);
        map.put("page","front-pages/orderlist.html");
        HttpSession session = request.getSession();
        session.setAttribute("orders",ordersList);
        return "index";
    }
}
