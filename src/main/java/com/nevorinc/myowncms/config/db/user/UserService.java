/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.config.db.user;

import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

public interface UserService {
      
    public List<User> getAllUsers();
    
    public User getUserByName(String name);
    
    public void deleteUser(String name);
    
    public void saveUser(User user);
    
    public void updateuser(User user);
    
    public boolean userExists(String name);
}
