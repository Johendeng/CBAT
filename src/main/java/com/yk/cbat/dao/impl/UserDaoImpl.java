package com.yk.cbat.dao.impl;

import com.yk.cbat.dao.UserDao;
import com.yk.cbat.entity.User;
import com.yk.cbat.util.PageUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JohenTeng on 2017/8/31.
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends CommonDaoImpl implements UserDao  {
    @Override
    public List<User> getUserByPage(PageUtil<User> page) {
        String hql = "from User";
        return super.commonSearchDao.searchHql(hql,null,page);
    }
}
