package com.nevorinc.myowncms.web.service.json;

import com.nevorinc.myowncms.db.inject.classinjector.FieldProperties;
import java.util.List;
import java.util.Set;

public interface FieldsJSON {

    /**
     * @return list of appended fields
     */
    public List<FieldProperties> getAppendedFields();

    /**
     * @return set of subtracted fields
     */
    public Set<String> getSubstractedFields();

    /**
     * @return set of necessary fields
     */
    public Set<String> getConstantFields();
}
