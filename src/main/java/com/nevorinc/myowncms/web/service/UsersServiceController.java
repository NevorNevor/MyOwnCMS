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
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     *
     * @return list of users
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        logger.debug("Try to #getUsers");
        return userService.getAllUsersWithoutPassword();
    }

    /**
     * Update User table
     *
     * @param user
     * @return update result
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseJSON updateUser(@RequestBody User user) {
        try {
            logger.debug("Try to #updateUser with user: " + user);
            userService.updateUser(user);
        } catch (HibernateException he) {
            return new ResponseJSON("DataBase exception - update failed");
        } catch (ConstraintViolationException cve) {
            //TO DO Constraints violation handler
            return new ResponseJSON(cve.getMessage());
        } finally {
            logger.debug("#updateUser fail: " + user);
        }
        return new ResponseJSON("successful");
    }

    /**
     * Add user to user table
     *
     * @param user
     * @return add result
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseJSON addUser(@RequestBody User user) {
        try {
            logger.debug("Try to #addUser with user: " + user);
            userService.saveUser(user);
        } catch (HibernateException he) {
            return new ResponseJSON("DataBase exception - add failed");
        } catch (ConstraintViolationException cve) {
            //TO DO Constraints violation handler
            return new ResponseJSON(cve.getMessage());
        } catch (PasswordException pe) {
            return new ResponseJSON(pe.getMessage());
        } finally {
            logger.debug("#addUser fail: " + user);
        }
        return new ResponseJSON("successful");
    }

    /**
     * Delete user from Users table by id
     *
     * @param id
     * @return delete result
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseJSON deleteUser(@PathVariable("id") int id) {
        try {
            logger.debug("Try to #deleteUser with user id: " + id);
            userService.deleteUser(id);
        } catch (HibernateException he) {
            return new ResponseJSON("DataBase exception - delete failed");
        } catch (ConstraintViolationException cve) {
            //TO DO Constraints violation handler
            return new ResponseJSON(cve.getMessage());
        } finally {
            logger.debug("#deleteUser fail: " + id);
        }
        return new ResponseJSON("successful");
    }

}
