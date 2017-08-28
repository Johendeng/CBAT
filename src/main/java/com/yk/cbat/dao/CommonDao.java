package com.yk.cbat.dao;

/**
 * Created by JohenTeng on 2017/5/15.
 */
public interface CommonDao<E> {
    /**
     * 添加
     * @param object 实体对象
     * @return 添加状态，true：成功，false：失败
     */
    boolean save(E object);

    /**
     * 删除
     * @param object 实体对象
     * @return 删除状态，true：成功，false：失败
     */
    boolean delete(E object);

    /**
     * 更新
     * @param object 实体对象
     * @return 更新状态，true：成功，false：失败
     */
    boolean update(E object);

}
