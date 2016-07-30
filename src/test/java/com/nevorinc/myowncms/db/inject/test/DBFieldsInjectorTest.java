package com.nevorinc.myowncms.db.inject.test;

import com.nevorinc.myowncms.db.dao.userdetails.dynamic.UserDetailsFieldInjector;
import com.nevorinc.myowncms.db.inject.classinjector.Accesses;
import com.nevorinc.myowncms.db.inject.dbinjector.DBFieldsInjector;
import com.nevorinc.myowncms.db.model.UserDetails;
import java.util.Properties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class DBFieldsInjectorTest {

    @Autowired
    private Environment env;

    private DBFieldsInjector injector;   
    
    @Test
    public void updateSchema() throws Exception {
        /*UserDetailsFieldInjector uDinjector = new UserDetailsFieldInjector();
        Class clazz = uDinjector.injectField(Accesses.PUBLIC, String.class, "jopa", "jopa_column");*/
        injector = new DBFieldsInjector(hibernateProperties(), UserDetails.class);
        injector.updateTables();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/owncms");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");
        return properties;
    }
}
