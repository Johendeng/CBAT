package com.yk.cbat.dao.impl;

import com.yk.cbat.dao.CommonDao;
import com.yk.cbat.dao.CommonSearchDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by JohenTeng on 2017/5/15.
 */
@Repository("commonDao")
public class CommonDaoImpl<E> implements CommonDao<E> {
    @Autowired
    private SessionFactory sessionFactory;
    @Resource(name = "commonSearchDaoImpl")
    protected CommonSearchDao<E> commonSearchDao;

    private Class<E> entity = null;
    public CommonDaoImpl() {
        Type type = this.getClass().getGenericSuperclass();
        if(type instanceof ParameterizedType){
            Type[] tps = ((ParameterizedType)type).getActualTypeArguments();
            entity = (Class<E>)tps[0];
        }
    }

    /**
     * 添加
     *
     * @param object 实体对象
     * @return 添加状态，true：成功，false：失败
     */
    @Override
    public boolean save(E object) {
        boolean state=false;
        try{
            Session session=sessionFactory.getCurrentSession();
            session.save(object);
            state=true;
            return state;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }

    /**
     * 删除
     *
     * @param object 实体对象
     * @return 删除状态，true：成功，false：失败
     */
    @Override
    public boolean delete(E object) {
        boolean state=false;
        try{
            Session session=sessionFactory.getCurrentSession();
            session.delete(object);
            state=true;
            return state;
        }catch (Exception e){
            e.printStackTrace();
        }

        return state;
    }

    /**
     * 更新
     *
     * @param object 实体对象
     * @return 更新状态，true：成功，false：失败
     */
    @Override
    public boolean update(E object) {
        boolean state=false;
        try{
            Session session=sessionFactory.getCurrentSession();
            session.update(object);
            state=true;
            return state;
        }catch (Exception e){
            e.printStackTrace();
        }
        return state;
    }


}
