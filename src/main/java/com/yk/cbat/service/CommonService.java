package com.yk.cbat.service;

/**
 * Created by JohenTeng on 2017/5/15.
 */
public interface CommonService<T> {
    /**
     * 添加
     * @param object 实体对象
     * @return 添加状态，true：成功，false：失败
     */
    boolean save(T object);

    /**
     * 删除
     * @param object 实体对象
     * @return 删除状态，true：成功，false：失败
     */
    boolean delete(T object);

    /**
     * 更新
     * @param object 实体对象
     * @return 更新状态，true：成功，false：失败
     */
    boolean update(T object);


}
