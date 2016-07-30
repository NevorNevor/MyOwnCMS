package com.nevorinc.myowncms.web.service;

import com.nevorinc.myowncms.web.service.json.ResponseJSON;
import com.nevorinc.myowncms.web.service.json.UserDetailsFieldsJSON;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name = "user_details")
public class UserDetailsServiceController {
    
    public ResponseJSON setUserDetailsFields(UserDetailsFieldsJSON fieldsJSON){
        return null;
    }
}
