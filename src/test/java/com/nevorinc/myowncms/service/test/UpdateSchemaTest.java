package com.nevorinc.myowncms.service.test;

import com.nevorinc.myowncms.config.AppConfig;
import com.nevorinc.myowncms.config.HibernateConfig;
import com.nevorinc.myowncms.config.SecurityConfig;
import com.nevorinc.myowncms.db.model.User;
import com.nevorinc.myowncms.db.model.UserDetails;
import java.util.Properties;
import javax.servlet.Filter;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, HibernateConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class UpdateSchemaTest {

    private MockMvc mockMvc;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;
    
    @Before
    public void setup() {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();
    }

    @Test
    public void updateSchema() {
        Configuration config = new Configuration();
        config.setProperties(hibernateProperties());
        config.addAnnotatedClass(UserDetails.class);
        config.addAnnotatedClass(User.class);
        SchemaUpdate schema = new SchemaUpdate(config);
        schema.execute(true, true);
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.connection.url", env.getRequiredProperty("jdbc.url"));
        properties.put("hibernate.connection.driver_class", env.getProperty("jdbc.driverClassName"));
        properties.put("hibernate.connection.username", env.getProperty("jdbc.username"));
        properties.put("hibernate.connection.password", env.getProperty("jdbc.password"));
        return properties;        
    }
}
