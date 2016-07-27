package com.nevorinc.myowncms.db.dao.userdetails;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserDetailsDao userDetailsDao;
    
    @Transactional(readOnly = true)
    public List getUserDetails(int user_id) {
        return userDetailsDao.getUserDetails(user_id);
    }
    
}
