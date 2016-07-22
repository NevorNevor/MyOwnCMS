package com.nevorinc.myowncms.service.test;

import com.nevorinc.myowncms.config.AppConfig;
import com.nevorinc.myowncms.config.HibernateConfig;
import com.nevorinc.myowncms.config.SecurityConfig;
import com.nevorinc.myowncms.db.dao.user.UserDao;
import com.nevorinc.myowncms.db.dao.user.UserService;
import com.nevorinc.myowncms.db.dao.user.UserServiceImpl;
import com.nevorinc.myowncms.db.model.User;
import com.nevorinc.myowncms.web.service.UsersServiceController;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.Filter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, HibernateConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class UserServiceControllerTest {
    
    @Mock
    private UserService userService;
    
    @InjectMocks
    @Resource
    private UsersServiceController serviceController;
    
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private List<User> users = new ArrayList<User>();

    private MockMvc mockMvc;

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();

        users.add(new User(1, "user", 1));
        users.add(new User(2, "admin", 0));
        users.add(new User(3, "vasya", 1));

        MockitoAnnotations.initMocks(this);
        when(userService.getAllUsersWithoutPassword()).thenReturn(users);
    }

    @Test
    public void getUsers_AllCOrrectTest() throws Exception {
        mockMvc.perform(get("/users"))
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
        
        verify(userService).getAllUsersWithoutPassword();
        verifyNoMoreInteractions(userService);
    }

}
