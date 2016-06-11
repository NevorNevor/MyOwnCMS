/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.config.db.user;

import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */

public interface UserDao {
    
    public List<User> getAllUsers();
    
    public User getUserByName(String name);
    
    public void deleteUser(String name);
    
    public void saveUser(User user);
    
}
