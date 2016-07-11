/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.web.service;

import com.nevorinc.myowncms.config.db.user.UserDaoImpl;
import com.nevorinc.myowncms.config.db.user.UserService;
import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersServiceController {     
    
    final static Logger logger = Logger.getLogger(UsersServiceController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getAllUsersWithoutPassword();
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(User user){
        logger.debug("Try to #updateUser with user: " + user);
        userService.updateUser(user);
        return user;
    }
         
}
