package com.yk.cbat.dao.impl;

import com.yk.cbat.dao.CommonSearchDao;
import com.yk.cbat.util.PageUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by JohenTeng on 2017/5/15.
 */

@Repository("commonSearchDaoImpl")
public class CommonSearchDaoImpl<T> implements CommonSearchDao<T> {

    private SessionFactory sessionFactory;
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<T> searchHql(String hql, Map<String, Object> params) {
        return this.searchHql(hql, params, null);
    }

    @Override
    public List<T> searchHql(String hql, Map<String, Object> params,PageUtil<T> paging) {
        List list = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(hql);
            if (params != null) {
                query=query.setProperties(params);
            }
            if (paging != null) {
                query.setFirstResult(paging.getBegin());
                query.setMaxResults(paging.getEnd());
            }
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public Object searchUnique(String hql, Map<String, Object> params) {
        Object obj = null;
        Session session;
        Query query ;

        try {
            session = this.sessionFactory.getCurrentSession();
            query = session.createQuery(hql);
            if (params != null) {
                query=query.setProperties(params);
            }
            obj = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    public int searchCount(String hql, Map<String, Object> params) {
        Object obj = searchUnique(hql, params);
        if (obj != null) {
            return ((Long) obj).intValue();
        }
        return 0;
    }

    @Override
    public int hqlExecuteUpdate(String hql, Serializable... serializables) {
        Session session ;
        Query query ;
        session = this.sessionFactory.getCurrentSession();
        query = session.createQuery(hql);
        for (int i = 0; i < serializables.length; i++) {
            query.setParameter(i, serializables[i]);
        }
        int i = query.executeUpdate();
        return i;
    }

    @Override
    public int hqlExecuteUpdate(String hql, List<Serializable> params) {
        Session session = null;
        Query query ;

        session = this.sessionFactory.getCurrentSession();
        query = session.createQuery(hql);
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i, params.get(i));
        }
        int i = query.executeUpdate();
        return i;
    }

    @Override
    public int sqlExecuteUpdate(String sql, Serializable... serializables) {
        Session session = null;
        Query query = null;
        session = this.sessionFactory.getCurrentSession();
        query = session.createSQLQuery(sql);
        for (int i = 0; i < serializables.length; i++) {
            query.setParameter(i, serializables[i]);
        }
        int i = query.executeUpdate();

        return i;
    }

    @Override
    public int sqlExecuteUpdate(String sql, Map<String, Object> params) {
        Session session = null;
        Query query = null;
        session = this.sessionFactory.getCurrentSession();
        query = session.createSQLQuery(sql);
        if (params != null) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        int i= query.executeUpdate();

        return i;
    }

    @Override
    public List sqlQuery(String sql, Map<String, Object> params) {
        Session session = null;
        Query query = null;
        session = this.sessionFactory.getCurrentSession();
        query = session.createSQLQuery(sql);
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        List l = query.list();
        return l;
    }

    @Override
    public List sqlQuery(String sql, Map<String, Object> params,PageUtil<T> paging, Class<T> entityClass) {
        Session session;
        Query query;
        session = this.sessionFactory.getCurrentSession();
        query = session.createSQLQuery(sql)
                .addEntity(entityClass);
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }

        query.setFirstResult(paging.getBegin());
        query.setMaxResults(paging.getEnd());
        List l =query.list();

        return l;
    }

    @Override
    public Object sqlUnique(String sql, Map<String, Object> params) {
        return null;
    }

    @Override
    public Object sqlUnique(String sql, Serializable... params) {
        Session session = null;
        Query query = null;
        session = this.sessionFactory.getCurrentSession();
        query = session.createSQLQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        Object obj=query.uniqueResult();

        return obj;
    }

    @Override
    public List<T> criteriaSearch(Class<T> classEntity, List<Criterion> filter) {
        Session session = null;
        Criteria query = null;
        session = this.sessionFactory.getCurrentSession();
        query = session.createCriteria(
                classEntity);


        if (filter != null) {
            for (Criterion c : filter) {
                query.add(c);
            }
        }
        List l = query.list();
        return l;
    }

    @Override
    public boolean validIsTransformPoint(String hql, Map<String, String> params) {
        return false;
    }


}
