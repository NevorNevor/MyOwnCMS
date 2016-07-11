package com.nevorinc.myowncms.config.initial;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nevorinc.myowncms.config.AppConfig;
import com.nevorinc.myowncms.config.AppConfig;
import com.nevorinc.myowncms.filters.AngularFilter;
import javax.servlet.Filter;
import javax.servlet.ServletRegistration;
import org.springframework.web.filter.CharacterEncodingFilter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
        protected Class<?>[] getServletConfigClasses() {
                return new Class<?>[] {};
        }

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

        @Override
        protected Filter[] getServletFilters() {
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            filter.setEncoding("UTF-8");
            AngularFilter angular = new AngularFilter();
            return new Filter[]{filter};
        }
	               
}