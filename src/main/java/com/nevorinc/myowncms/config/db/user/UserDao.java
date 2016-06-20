package com.nevorinc.myowncms.config.db.user;

import com.nevorinc.myowncms.db.model.User;
import java.util.List;

public interface UserDao {
    
    public List<User> getAllUsers();
    
    public List<User> getAllUsersWithoutPassword();
            
    public User getUserByName(String name);
    
    public User getUserById(int id);
    
    public void deleteUser(String name);
    
    public void saveUser(User user);  
}
