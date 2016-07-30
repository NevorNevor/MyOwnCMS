package com.nevorinc.myowncms.db.inject.dbinjector;

import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class DBFieldsInjector {

    private Configuration config;

    public DBFieldsInjector(Properties hibernateProperties, Class... updatedModelClasses) {
        config = new Configuration();
        config.setProperties(hibernateProperties);
        for (Class clazz : updatedModelClasses) {
            config.addAnnotatedClass(clazz);
        }       
    }
    
    public void updateTables(){
        SchemaUpdate schema = new SchemaUpdate(config);
        schema.execute(true, true);
    }

}
