package com.nevorinc.myowncms.db.inject.classinjector;

import com.nevorinc.myowncms.db.dao.exceptions.ConstantFieldAlterException;
import com.nevorinc.myowncms.web.service.json.FieldsJSON;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository("fieldChecker")
public class FieldChecker {

    /**
     * @param FieldsJSON recived from client
     * @return set of checked FieldProperties
     */
    public Set<FieldProperties> fieldsAssembler(FieldsJSON fields) {
        Set<String> constantFields = fields.getConstantFields();
        Set<FieldProperties> fieldsProperties = new HashSet<FieldProperties>();
        for (FieldProperties field : fields.getAppendedFields()) {
            Class type = field.getFieldType();
            String fieldName = field.getFieldName();
            if (!constantFields.contains(fieldName)) {
                fieldsProperties.add(field);
            } else {
                throw new ConstantFieldAlterException();
            }
        }
        return fieldsProperties;
    }

    /**
     * @param fields recived from client
     * @param tableName - dropped column's table name 
     * @return delete field query string
     */
    public String deleteFields(FieldsJSON fields, String tableName) {
        Set<String> constantFields = fields.getConstantFields();
        StringBuilder dropColumnsQuery = new StringBuilder("ALTER TABLE " + tableName);
        for (String field : fields.getSubstractedFields()) {
            if (!constantFields.contains(field)) {
                dropColumnsQuery.append(" DROP " + field + ",");
            } else {
                throw new ConstantFieldAlterException();
            }
        }
        int lastCommaIndex = dropColumnsQuery.lastIndexOf(",");
        dropColumnsQuery.replace(lastCommaIndex, lastCommaIndex, ";");
        return dropColumnsQuery.toString();
    }

}
