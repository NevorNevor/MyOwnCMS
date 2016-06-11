/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.web.controller;

import com.nevorinc.myowncms.config.db.user.UserService;
import com.nevorinc.myowncms.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 * @author Admin
 */
@Controller
@Transactional
public class MainController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView mainPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("main");
        List<User> users = userService.getAllUsers();
        model.addObject("users", users);
        return model;
    }
    
    @RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
    public ModelAndView registrationForm(){
        ModelAndView model = new ModelAndView();
        model.setViewName("registration");
        return model;
    }
    
    @RequestMapping(value = { "/registration"}, method = RequestMethod.POST)
    public ModelAndView userRegistration(
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "password", required = false) String password,
                                        @RequestParam(name = "email", required = false) String email){
        ModelAndView model = new ModelAndView();
        try {
            if ((name == null) || (password == null) || (email == null)) {
                throw new IllegalArgumentException();
            }     
            if ((name.equals("")) || (password.equals("")) || (email.equals(""))) {
                throw new Exception();
            }            
            User user = new User(name, password, 1);
            userService.saveUser(user);        
            model.addObject("registred", true);
        } catch (IllegalArgumentException e) {
            model.addObject("error", true);       
        } catch (Exception e) {
            model.addObject("error", true);
        }
        model.setViewName("registration");
        return model;
    }
    
    @RequestMapping(value = { "/login**" }, method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                        @RequestParam(value = "logout", required = false) String logout){  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equals("anonymousUser")){
            return new ModelAndView("redirect:mainmenu");  
        }
        ModelAndView model = new ModelAndView();                        
        if (error != null) {
                model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
                model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }
    
    @RequestMapping(value = { "/403**" }, method = RequestMethod.GET)
    public ModelAndView errorPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        
        return model;
    }
    
    @RequestMapping(value = { "/adminpage**" }, method = RequestMethod.GET)
    public ModelAndView adminPanelPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("adminpage");
        
        return model;
    }
    
}
