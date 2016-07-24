package com.nevorinc.myowncms.db.dao.roles;

import com.nevorinc.myowncms.config.db.AbstractDao;
import com.nevorinc.myowncms.db.model.UserRole;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userRolesDao")
public class UserRolesDaoImpl extends AbstractDao<Integer, UserRole> implements UserRolesDao {

    final static Logger logger = Logger.getLogger(UserRolesDaoImpl.class);
    
    /**
     * Get UserRole by user_id and authority
     * @param id
     * @param authority
     * @return UserRole or null if role not found
     */
    public UserRole getRoleByUserIdAndAuthority(int id, String authority) {
        logger.debug(String.format("Try to #getRoleByUserIdAndAuthority with id=%d and authority=%s",id,authority));
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user_id", id));
        criteria.add(Restrictions.eq("role", authority));
        return (UserRole) criteria.uniqueResult();
    }

    /**
     * Get UserRole list by user_id
     * @param id
     * @return UserRole list
     */
    public List<UserRole> getRolesByUserId(int id) {
        logger.debug(String.format("Try to #getRolesByUserIdwith id=%d", id));
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user_id", id));
        return criteria.list();
    }

    /**
     * Get string list of all user's aithorities by user_id 
     * @param id
     * @return authorities list
     */
    public List<String> getAuthoritiesByUserId(int id) {
        logger.debug(String.format("Try to #getAuthoritiesByUserId id=%d", id));
        Query query = getQuery("select roles from user_roles where user_id = :id");
        query.setInteger("id", id);
        return query.list();
    }

    /**
     * Get string list of all exists aithorities
     * @return list of authorities
     */
    public List<String> getAllRoles() {
        logger.debug(String.format("Try to #getAllRoles"));
        Query query = getQuery("SELECT role FROM user_roles GROUP BY role");
        return query.list();
    }

    /**
     * Save or update given UserRole
     * @param entity 
     */
    public void saveOrUpdate(UserRole entity) {
        logger.debug(String.format("Try to #saveOrUpdate UserRole=%s", entity));
        getTemplate().merge(entity);
    }

    /**
     * Delete given UserRole
     * @param entity 
     */
    public void deleteRole(UserRole entity) {
        logger.debug(String.format("Try to #deleteRole UserRole=%s", entity));
        getTemplate().delete(entity);
    }

    /**
     * Delete all user's roles by id
     * @param id 
     */
    public void deleteRolesByUserId(int id) {
        logger.debug(String.format("Try to #deleteRolesByUserId id=%d", id));
        Query query = getQuery("DELETE FROM user_roles WHERE user_id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

}
