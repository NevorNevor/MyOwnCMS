package com.nevorinc.myowncms.db.dao.roles;

import com.nevorinc.myowncms.db.model.UserRole;
import java.util.List;

public interface UserRolesDao {
    
    public List<UserRole> getRolesByUserId(int id);
    
    public List<String> getAuthoritiesByUserId(int id);
    
    public UserRole getRoleByUserIdAndAuthority(int id, String authority);
    
    public List<String> getAllRoles();
    
    public void saveOrUpdate(UserRole entity);     
    
    public void deleteRole(UserRole entity);
    
    public void deleteRolesByUserId(int id);
    
}
