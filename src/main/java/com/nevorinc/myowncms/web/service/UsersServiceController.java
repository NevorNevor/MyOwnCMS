/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.web.service;

import com.nevorinc.myowncms.db.dao.exceptions.PasswordException;
import com.nevorinc.myowncms.db.dao.user.UserService;
import com.nevorinc.myowncms.db.model.User;
import com.nevorinc.myowncms.web.service.json.ResponseJSON;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<User> getUsers() {
        return userService.getAllUsersWithoutPassword();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseJSON updateUser(@RequestBody User user) {
        try {
            logger.debug("Try to #updateUser with user: " + user);
            User updatedUser = userService.updateUser(user);
        } catch (HibernateException he) {
            return new ResponseJSON("DataBase exception - update failed");
        } catch (ConstraintViolationException cve) {
            //TO DO Constraints violation handler
            return new ResponseJSON(cve.getMessage());
        }
        return new ResponseJSON("successful");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseJSON addUser(@RequestBody User user) {
        try {
            logger.debug("Try to #addUser with user: " + user);
            User addedUser = userService.saveUser(user);
        } catch (HibernateException he) {
            return new ResponseJSON("DataBase exception - update failed");
        } catch (ConstraintViolationException cve) {
            //TO DO Constraints violation handler
            return new ResponseJSON(cve.getMessage());
        } catch (PasswordException pe) {
            return new ResponseJSON(pe.getMessage());
        }
        return new ResponseJSON("successful");
    }

}
