package edu.suse.bookstore.controller;

import edu.suse.bookstore.domain.User;
import edu.suse.bookstore.service.UserService;
import net.suncaper.project_api.common.utils.JsonMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/check-username")
    @ResponseBody
    public Boolean checkUserName(@RequestParam("userId") String id,@RequestParam("username") String username) {
        return userService.findUserName(id, username);
    }

    @PostMapping("/save")
    @ResponseBody
    public Object saveUser(User user) {
        return new JsonMap(userService.saveUser(user)).end();
    }

    @GetMapping("/find")
    @ResponseBody
    public Object findUserById(@RequestParam("userId") String userId){
        User user = userService.findUserById(userId);
        return new JsonMap(user).end();
    }


}
