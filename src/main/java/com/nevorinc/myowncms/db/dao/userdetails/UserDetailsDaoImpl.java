package com.nevorinc.myowncms.db.dao.userdetails;

import com.nevorinc.myowncms.config.db.AbstractDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("userDetailsDao")
public class UserDetailsDaoImpl extends AbstractDao<Integer, UserDetails> implements UserDetailsDao{

    public List getUserDetails(int user_id) {
        Query query = getQuery("SELECT * FROM user_details WHERE user_id = :id");
        query.setInteger("id", user_id);
        return query.list();
    }
    
}
