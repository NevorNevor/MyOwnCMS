package com.nevorinc.myowncms.db.dao.user_roles;

import com.nevorinc.myowncms.config.db.AbstractDao;
import com.nevorinc.myowncms.db.model.UserRoles;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

public class UserRolesDaoImpl extends AbstractDao<Integer, UserRoles> implements UserRolesDao{

    

    
    
    public void saveOrUpdate(UserRoles entity){
        getTemplate().merge(entity);
    }
    
    public List<UserRoles> getByUserId(int id){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user_id", id));
        return criteria.list();
    }
    
}
