package com.yk.cbat.dao;

import com.yk.cbat.util.PageUtil;
import org.hibernate.criterion.Criterion;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by JohenTeng on 2017/5/15.
 */

public interface CommonSearchDao<T>  {
    /**
     * 根据hql查询数据
     * @param hql
     * @param params
     * @return
     */
    List<T> searchHql(String hql, Map<String, Object> params);

    /**
     *
     * @param hql  根据hql查询分页数据
     * @param params
     * @param paging
     * @return
     */
    List<T> searchHql(String hql, Map<String, Object> params, PageUtil<T> paging);

    /**
     * 根据hql查询满足条件的唯一对象
     * @param hql
     * @param params
     * @return
     */
    Object searchUnique(String hql, Map<String, Object> params);

    /**
     * 根据hql统计个数
     * @param hql
     * @param params
     * @return
     */
    int searchCount(String hql, Map<String, Object> params);

    /**
     * 批量增，删，改操作
     *
     * @param hql
     * @param serializables
     */
    int hqlExecuteUpdate(String hql, Serializable... serializables);

    /**
     * 批量增，删，改操作
     *
     * @param hql
     * @param params
     */
    int hqlExecuteUpdate(String hql, List<Serializable> params);

    /**
     * 批量增，删，改操作
     * @param sql
     * @param serializables
     */
    int sqlExecuteUpdate(String sql, Serializable... serializables);

    /**
     * 批量增，删，改操作
     * @param sql
     * @param params
     */
    int sqlExecuteUpdate(String sql, Map<String, Object> params);

    /**
     * sql查询
     *
     * @param sql
     * @param params
     * @return
     */
    List sqlQuery(String sql, Map<String, Object> params);

    /**
     * sql分页查询
     * @param sql
     * @param params
     * @param paging
     * @param entityClass 类型
     * @return
     */
    List sqlQuery(String sql, Map<String, Object> params, PageUtil<T> paging, Class<T> entityClass);


    /**
     * sql查询返回唯一对象
     *
     * @param sql
     * @param params
     * @return
     */
    Object sqlUnique(String sql, Map<String, Object> params);

    /**
     * sql查询返回唯一对象
     * @param sql
     * @param params
     * @return
     */
    Object sqlUnique(String sql, Serializable... params);

    /**
     * 使用Criteria查询
     * @param classEntity
     * @return
     */
    List<T> criteriaSearch(Class<T> classEntity, List<Criterion> filter);


    boolean validIsTransformPoint(String hql, Map<String, String> params);
}
