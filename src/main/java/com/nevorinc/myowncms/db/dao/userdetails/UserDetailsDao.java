package com.nevorinc.myowncms.db.dao.userdetails;

import com.nevorinc.myowncms.web.service.json.FieldsJSON;
import java.util.List;

public interface UserDetailsDao {
    
    public Object getUserDetails(int user_id);
    
    public List getUsersDetails();
    
    public void setFields(FieldsJSON fields);
    
    public void deleteFields(FieldsJSON fields);
}
