package com.nevorinc.myowncms.db.dao.user_roles;

import com.nevorinc.myowncms.db.model.UserRoles;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRolesServiceImpl implements UserRolesService{
    
    @Autowired
    private UserRolesDao userRolesDao;

    public List<String> getAuthorityByUserId(int id) {
        Query query = userRolesDao.getQuery("select roles from user_roles where user_id = :id");
        query.setInteger("id", id);
        return query.list();
    }

    public void setAuthorityByUserId(int id) {
        getTemplate().saveOrUpdate(id);
    }

    public void saveOrUpdate(UserRoles entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<UserRoles> getByUserId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
