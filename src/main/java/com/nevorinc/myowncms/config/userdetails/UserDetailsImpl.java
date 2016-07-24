package com.nevorinc.myowncms.config.userdetails;

import com.nevorinc.myowncms.db.dao.roles.UserRolesService;
import com.nevorinc.myowncms.db.model.User;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author SpyPC
 */
public class UserDetailsImpl implements UserDetails {

    @Autowired
    private UserRolesService userRolesService;
    
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRolesService.getRolesByUserId(user.getId());
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.getEnabled() == 1;
    }
}
