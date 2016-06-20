package com.nevorinc.myowncms.config.db.user;

import com.nevorinc.myowncms.config.db.AbstractDao;
import com.nevorinc.myowncms.db.model.User;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{           
    
    final static Logger logger = Logger.getLogger(UserDaoImpl.class);
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
     * Returned list of registered users without password
     * @return List<User> 
     */
    @Override
    public List<User> getAllUsersWithoutPassword() {
        Query query = getSession().createQuery("Select new User(id, username, enabled) from User");
        return query.list();
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
     * Returned User.class object by user id
     * @param id
     * @return User 
     */
    @Override
    public User getUserById(int id) {
        logger.debug("Try to #getUserById with id: " + id);
        Criterion c = Restrictions.eq("id", id);
        Criteria criteria = createEntityCriteria();
        User user = (User) criteria.add(c).uniqueResult(); 
        logger.debug("#getUserById with id: " + id + " result is " + user);
        return user;
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
        logger.debug("Try to persist " + user);
        persist(user);
    }       
}
