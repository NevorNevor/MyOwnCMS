package com.nevorinc.myowncms.service.test;

import com.nevorinc.myowncms.config.AppConfig;
import com.nevorinc.myowncms.config.HibernateConfig;
import com.nevorinc.myowncms.config.SecurityConfig;
import com.nevorinc.myowncms.db.model.User;
import javax.servlet.Filter;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, HibernateConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class UserDetailsServiceControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();

        MockitoAnnotations.initMocks(this);

    }
    
    @Test
    public void getUsers_AllCOrrectTest() throws Exception {

        mockMvc.perform(get("/user_details"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].username", is("user")))
                .andExpect(jsonPath("$[0].password", is(nullValue())))
                .andExpect(jsonPath("$[0].enabled", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].username", is("admin")))
                .andExpect(jsonPath("$[1].password", is(nullValue())))
                .andExpect(jsonPath("$[1].enabled", is(0)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].username", is("vasya")))
                .andExpect(jsonPath("$[2].password", is(nullValue())))
                .andExpect(jsonPath("$[2].enabled", is(1)));
    }
}
