package com.yk.cbat.service.impl;

import com.yk.cbat.dao.UserDao;
import com.yk.cbat.entity.User;
import com.yk.cbat.service.UserService;
import com.yk.cbat.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by JohenTeng on 2017/8/31.
 */
@Service
public class UserServiceImpl extends CommonServiceImpl implements UserService {

    private UserDao userDao;
    @Resource(name = "userDaoImpl")
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
        super.setCommonDao(userDao);
    }

    @Override
    public List<User> getUserByPage(PageUtil<User> page) {
        return userDao.getUserByPage(page);
    }
}
