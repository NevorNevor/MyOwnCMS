package com.nevorinc.myowncms.db.inject.classinjector;

public class FieldProperties {
    
    private Class fieldType;
    private String fieldName;

    public FieldProperties(Class fieldType, String fieldName) {
        this.fieldType = fieldType;
        this.fieldName = fieldName;
    }

    public Class getFieldType() {
        return fieldType;
    }

    public void setFieldType(Class fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }    
    
}
