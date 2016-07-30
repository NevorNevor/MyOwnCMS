package com.nevorinc.myowncms.db.dao.userdetails;

import com.nevorinc.myowncms.config.db.DynamicAbstractDao;
import com.nevorinc.myowncms.db.dao.userdetails.dynamic.UserDetailsFieldInjector;
import com.nevorinc.myowncms.db.inject.classinjector.FieldChecker;
import com.nevorinc.myowncms.db.inject.classinjector.FieldProperties;
import com.nevorinc.myowncms.web.service.json.FieldsJSON;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDetailsDao")
public class UserDetailsDaoImpl extends DynamicAbstractDao implements UserDetailsDao {

    @Autowired
    private FieldChecker fieldChecker;
    
    @Autowired
    private UserDetailsFieldInjector userDetailsFieldInjector;

    public Object getUserDetails(int user_id) {
        Query query = getQuery("SELECT * FROM user_details WHERE user_id = :id");
        query.setInteger("id", user_id);
        return query.uniqueResult();
    }

    public List getUsersDetails() {
        Query query = getQuery("SELECT * FROM user_details");
        return query.list();
    }

    public void setFields(FieldsJSON fields) {
        Set<FieldProperties> fieldsProperties = fieldChecker.fieldsAssembler(fields);
        userDetailsFieldInjector.injectFields(fieldsProperties);
    }

    public void deleteFields(FieldsJSON fields) {
        String query = fieldChecker.deleteFields(fields, "user_details");
        
    }

}
