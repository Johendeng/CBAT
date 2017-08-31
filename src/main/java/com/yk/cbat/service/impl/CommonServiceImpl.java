package com.yk.cbat.service.impl;

import com.yk.cbat.dao.CommonDao;
import com.yk.cbat.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * Created by JohenTeng on 2017/5/15.
 */
@Service
public class CommonServiceImpl<T> implements CommonService<T> {

    private CommonDao<T> commonDao = null;
    protected void setCommonDao(CommonDao commonDao){
        this.commonDao=commonDao;
    }

    @Override
    public boolean save(T object) {
        return this.commonDao.save(object);
    }

    @Override
    public boolean delete(T object) {
        return this.commonDao.delete(object);
    }

    @Override
    public boolean update(T object) {
        return this.commonDao.update(object);
    }

}
