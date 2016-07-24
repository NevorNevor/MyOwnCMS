package com.nevorinc.myowncms.db.dao.roles;

import com.nevorinc.myowncms.db.model.UserRole;
import java.util.List;

public interface UserRolesService {
    
    public List<String> getAuthoritiesByUserId(int id);
          
    public List<UserRole> getRolesByUserId(int id);
    
    public List<String> getAllRoles();
    
    public void addAuthorityToUserById(int id, String authority);
    
    public void deleteUserRolesById(int id);
}
