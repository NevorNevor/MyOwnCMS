package com.nevorinc.myowncms.config.db;

import com.nevorinc.myowncms.web.service.json.FieldsJSON;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.nevorinc.myowncms.db.inject.classinjector.FieldChecker;

public abstract class DynamicAbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*public DynamicAbstractDao(){
        String queryString = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='" + getTableName() + "'";
        Query query = getQuery(queryString);
        dynamicFields = new HashSet(query.list());
    }*/
    //protected abstract String getTableName();

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Query getQuery(String sqlString) {
        return getSession().createSQLQuery(sqlString);
    }

}
