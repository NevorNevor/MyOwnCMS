package com.nevorinc.myowncms.db.dao.userdetails.dynamic;

import com.nevorinc.myowncms.db.inject.classinjector.FieldInjector;
import org.springframework.stereotype.Repository;

@Repository("userDetailsFieldInjector")
public class UserDetailsFieldInjector extends FieldInjector{

    @Override
    protected String getClassString() {
        return "com.nevorinc.myowncms.db.model.UserDetails";
    }
    
}
