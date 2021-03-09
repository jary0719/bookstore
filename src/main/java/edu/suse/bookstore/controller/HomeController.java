package edu.suse.bookstore.controller;

import edu.suse.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }
    /*方式一：通过Ribbon实现远程调用
    @Autowired
    private RestTemplate restTemplate;*/

   /* 方式二：
   @Autowired
    private UserClient helloClient;*/
   @GetMapping("/system-index")
   public String systemIndex(ModelMap map){
       map.put("page","system-index/data-chart");
       return "system-index";
   }

   @GetMapping("/index")
   public String index(ModelMap map, HttpServletRequest request){
       map.put("recommend",bookService.selectRecommendBook());
       map.put("page","front-pages/home.html");
       HttpSession session = request.getSession();
       session.setAttribute("allType",bookService.allType());
       return "index";
   }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/error/403")
    public String page403(ModelMap map) {
        map.put("page", "include/error/403");
        return "system-index";
    }

    @GetMapping("/error/404")
    public String page404(ModelMap map) {
        map.put("page", "include/error/404");
        return "system-index";
    }

    /*@GetMapping("test")
    @ResponseBody
    public String test(){
        *//*
        方式一：
        String result = restTemplate.getForObject("http://USER-PROVIDER/hello", String.class);
        *//*

     *//*方式二：
        return helloClient.hello();*//*
    }*/
}
