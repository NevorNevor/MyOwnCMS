package com.nevorinc.myowncms.db.inject.test;

import com.nevorinc.myowncms.db.dao.userdetails.dynamic.UserDetailsFieldInjector;
import javax.persistence.Column;
import com.nevorinc.myowncms.db.inject.classinjector.Accesses;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldInjectorTest {

    private UserDetailsFieldInjector userDetailsFiledInjector;
    
    @Before
    public void setup(){
        userDetailsFiledInjector = new UserDetailsFieldInjector();
    }
    
    @Test
    public void injectFieldTest() throws Exception{
        Class injectable = userDetailsFiledInjector.injectField(String.class, "testField");
        Field field = injectable.getField("testField");
        Column annotation = field.getAnnotation(Column.class);
        
        assertNotNull(field);       
        assertTrue(Modifier.isPublic(field.getModifiers()));
        assertFalse(Modifier.isStatic(field.getModifiers()));
        assertNotNull(annotation);
        assertEquals(annotation.name(), "test_field");
    }
}
