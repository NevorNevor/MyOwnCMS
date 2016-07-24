package com.nevorinc.myowncms.db.dao.roles;

import com.nevorinc.myowncms.db.dao.exceptions.RoleAlreadyInUseException;
import com.nevorinc.myowncms.db.model.UserRole;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userRolesService")
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesDao userRolesDao;

    /**
     * Get string list of all user's aithorities by user_id 
     * @param id
     * @return authorities list
     */
    @Transactional(readOnly = true)
    public List<String> getAuthoritiesByUserId(int id) {
        return userRolesDao.getAuthoritiesByUserId(id);
    }

    /**
     * Get UserRole list by user_id
     * @param id
     * @return UserRole list
     */
    @Transactional(readOnly = true)
    public List<UserRole> getRolesByUserId(int id) {
        return userRolesDao.getRolesByUserId(id);
    }

    /**
     * Get string list of all exists aithorities
     * @return list of authorities
     */
    @Transactional(readOnly = true)
    public List<String> getAllRoles() {
        return userRolesDao.getAllRoles();
    }

    /**
     * Save UserRole if role not exists
     * @param id
     * @param authority 
     * throws RoleAlreadyInUseException if role exists
     */
    public void addAuthorityToUserById(int id, String authority) throws RoleAlreadyInUseException{
        if (userRolesDao.getRoleByUserIdAndAuthority(id, authority) != null) {
            throw new RoleAlreadyInUseException();
        }
        userRolesDao.saveOrUpdate(new UserRole(id, authority));
    }

    /**
     * Delete all user's roles by id
     * @param id 
     */
    public void deleteUserRolesById(int id) {
        userRolesDao.deleteRolesByUserId(id);
    }

}
