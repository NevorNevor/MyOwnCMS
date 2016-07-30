package com.nevorinc.myowncms.web.service.json;

import com.nevorinc.myowncms.db.inject.classinjector.FieldProperties;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Field fields contains all editable UserDetail's fields
 *
 * @author Admin
 */
public class UserDetailsFieldsJSON implements FieldsJSON {

    private static final Set<String> constantFields = new HashSet<String>(Arrays.asList(new String[]{"id", "user_id"}));

    private Set<String> substractedFields;

    private List<FieldProperties> fields;

    public Set<String> getConstantFields() {
        Set<String> constantFieldsCopy = new HashSet<String>();
        constantFieldsCopy.addAll(constantFields);
        return constantFieldsCopy;
    }

    public Set<String> getSubstractedFields() {
        return substractedFields;
    }

    public void setSubstractedFields(Set<String> subtractedFields) {
        this.substractedFields = subtractedFields;
    }

    public List<FieldProperties> getAppendedFields() {
        return fields;
    }

    public void setFields(List<FieldProperties> fields) {
        this.fields = fields;
    }

}
