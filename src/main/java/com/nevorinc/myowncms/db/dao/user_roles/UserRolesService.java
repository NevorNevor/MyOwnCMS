package com.nevorinc.myowncms.db.dao.user_roles;

import com.nevorinc.myowncms.db.model.UserRoles;
import java.util.List;

public interface UserRolesService {
    
    public List<String> getAuthorityByUserId(int id);
    
    public void setAuthorityByUserId(int id);
    
    public void saveOrUpdate(UserRoles entity);
    
    public List<UserRoles> getByUserId(int id);
}
