package com.nevorinc.myowncms.config.userdetails;

import com.nevorinc.myowncms.db.dao.user.UserService;
import com.nevorinc.myowncms.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;   

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " user not found");
        }
        return new UserDetailsImpl(user);
    }

}
