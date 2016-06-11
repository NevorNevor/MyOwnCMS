package com.nevorinc.myowncms.web.controller;

import com.nevorinc.myowncms.config.db.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin*")
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/","main"})
    public String adminMain(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "admin_views/admin_main";
    }
}
