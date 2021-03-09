package edu.suse.bookstore.controller;

import edu.suse.bookstore.domain.Role;
import edu.suse.bookstore.domain.User;
import edu.suse.bookstore.service.RoleService;
import edu.suse.bookstore.service.UserService;
import net.suncaper.project_api.common.PagableResponse;
import net.suncaper.project_api.common.PageRequest;
import net.suncaper.project_api.common.utils.JsonMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String userListPage(ModelMap map) {
        map.put("page", "user/user-list");
        return "system-index";
    }

    @GetMapping("/clerk")
    public String clerkPage(ModelMap map){
        map.put("page","user/clerk");
        return "system-index";
    }

    @GetMapping("/user-add")
    public String addUser(ModelMap map) {
        map.put("user", new User());
        map.put("type","add");
        return "user/widget/user-edit.html";
    }

    @GetMapping("/clerk-add")
    public String addClerk(ModelMap map) {
        map.put("user",new User());
        map.put("customers",userService.customerList());
        return "user/widget/clerk-add.html";
    }

    @GetMapping("/user-edit")
    public String updateUserById(@RequestParam("id") String id, ModelMap map) {
        map.put("user", userService.findUserById(id));
        map.put("type","edit");
        return "user/widget/user-edit.html";
    }

    @GetMapping("/user-list")
    @ResponseBody
    public PagableResponse userList(PageRequest request, @RequestParam("keyword") String keyword) {
        return userService.userList(request, keyword);
    }

    @GetMapping("/clerk-list")
    @ResponseBody
    public PagableResponse clerkList(PageRequest request, @RequestParam("keyword") String keyword) {
        return userService.clerkList(request, keyword);
    }

    @PostMapping("/expel")
    @ResponseBody
    public Object expelClerk(@RequestParam("id") String id){
        return userService.expelClerkById(id);
    }

    @DeleteMapping("/user")
    @ResponseBody
    public Object deleteUserById(@RequestParam("id") String... ids) {
        userService.deleteUserById(ids);
        return 1;
    }

    @PostMapping("/clerk-save")
    @ResponseBody
    public Object saveClerk(@RequestParam("username") String userId) {
        return new JsonMap(userService.saveClerk(userId)).end();
    }

    @GetMapping("/role")
    public String roleListPage(ModelMap map) {
        map.put("page", "role/role-list.html");
        return "system-index";
    }

    @GetMapping("/role-list")
    @ResponseBody
    public PagableResponse roleList(PageRequest request) {
        return roleService.roleList(request);
    }

    @DeleteMapping("/role")
    @ResponseBody
    public Object deleteRoleById(@RequestParam("id") Integer... ids) {
        roleService.deleteRoleById(ids);
        return 1;
    }

    @GetMapping("/role-add")
    public String addRole(ModelMap map) {
        map.put("role",new Role());
        return "role/widget/role-add.html";
    }

    @PostMapping("/role-save")
    @ResponseBody
    public Object saveRole(Role role) {
        return new JsonMap(roleService.saveRole(role)).end();
    }
}
