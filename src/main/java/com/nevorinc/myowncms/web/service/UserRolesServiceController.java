package com.nevorinc.myowncms.web.service;

import com.nevorinc.myowncms.db.dao.exceptions.RoleAlreadyInUseException;
import com.nevorinc.myowncms.db.dao.roles.UserRolesService;
import com.nevorinc.myowncms.web.service.json.ResponseJSON;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class UserRolesServiceController {

    @Autowired
    private UserRolesService userRolesService;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getUserRoles() {
        return userRolesService.getAllRoles();
    }

    @RequestMapping(value = "{user_id}/{authority}", method = RequestMethod.POST)
    public ResponseJSON addUserAuthority(@PathVariable(value = "user_id") int user_id,
            @PathVariable(value = "authority") String authority) {
        try {
            userRolesService.addAuthorityToUserById(user_id, authority);
        } catch (RoleAlreadyInUseException raiue) {
            return new ResponseJSON(raiue.getMessage());
        }
        return new ResponseJSON("success");
    }
}
