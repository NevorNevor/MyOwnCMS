/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.config.db;

/**
 *
 * @author Admin
 */
import com.nevorinc.myowncms.config.db.user.UserDaoImpl;
import java.io.Serializable;
 
import java.lang.reflect.ParameterizedType;
import org.apache.log4j.Logger;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.hibernate4.HibernateTemplate;

@Configurable
public abstract class AbstractDao<PK extends Serializable, T> {
    
    final static Logger logger = Logger.getLogger(AbstractDao.class);
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    protected HibernateTemplate getTemplate(){
        HibernateTemplate template = new HibernateTemplate(sessionFactory);
        return template;
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getTemplate().get(persistentClass, key);
    }
    
    public Query getQuery(String sqlString){
        return getSession().createSQLQuery(sqlString);
    }
    
    public void persist(T entity) {
        getTemplate().persist(entity);
        logger.debug("#persist successful " + entity);
    }
    
    public void update(T entity) {
        getTemplate().merge(entity);
        logger.debug("#update successful " + entity);
    }
 
    public void delete(T entity) {
        getTemplate().delete(entity);
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
 
}
