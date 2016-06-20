package com.nevorinc.myowncms.web.controller;

import com.nevorinc.myowncms.config.db.user.UserService;
import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin*")
public class AdminController {
    
    @RequestMapping(value = {"/","main"})
    public String adminMain(Model model){
        return "admin_views/admin_main";
    }
    
    @RequestMapping(value = {"/users"})
    public String adminUsers(Model model){
        return "admin_views/admin_users";
    }
    
    /*@RequestMapping(value={"/user_list"}, produces = "application/json")
    public @ResponseBody List<User> getUsers(){
        return userService.getAllUsers();
    }*/
}
