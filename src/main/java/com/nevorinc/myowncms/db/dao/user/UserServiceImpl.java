/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.config.db.user;

import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    final static Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordEncoder encoder;
    
    /**
     * Returned list of registered users
     * @return List<User> 
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * Returned list of registered users without password
     * @return List<User> 
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsersWithoutPassword() {
        return userDao.getAllUsersWithoutPassword();
    }

    /**
     * Returned User.class object by user name
     * @param name
     * @return User 
     */
    @Override
    @Transactional(readOnly = true)
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    /**
     * Delete user from Users by name
     * @param name 
     */
    @Override
    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    /**
     * Save user in Users table
     * @param user 
     */
    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);
        userDao.saveUser(user);
        return user;
    }

    /**
     * Update current user
     * @param user 
     */
    @Override
    public User updateUser(User user) {
        logger.debug("Try to #updateUser with user: " + user);
        User oldUser = userDao.getUserById(user.getId());
        if (oldUser != null){
            user.setPassword(oldUser.getPassword());
            userDao.updateUser(user);
        }
        return user;
    }

    /**
     * Return true if user with name exist
     * @param name
     * @return true if exist
     */
    @Override
    public boolean userExists(String name) {
        User user = userDao.getUserByName(name);
        return user != null;
    }               
}
