/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.config.db.user;

import com.nevorinc.myowncms.config.db.AbstractDao;
import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{           
    
    /**
     * Returned list of registered users
     * @return List<User> 
     */
    @Override
    public List<User> getAllUsers() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }
    
    /**
     * Returned User.class object by user name
     * @param name
     * @return User 
     */
    @Override
    public User getUserByName(String name) {
        Criterion c = Restrictions.eq("username", name);
        Criteria criteria = createEntityCriteria();
        return (User) criteria.add(c).uniqueResult();
    }
    
    /**
     * Delete user from Users by name
     * @param name 
     */
    @Override
    public void deleteUser(String name) {
        Query q = getQuery("delete from Users where username = :name");
        q.setString("name", name);
        q.executeUpdate();
    }

    /**
     * Save user in Users table
     * @param user 
     */
    @Override
    public void saveUser(User user) {
        persist(user);
    }
    
    
    
    
        
}
