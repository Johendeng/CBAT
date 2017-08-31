package com.yk.cbat.service;

import com.yk.cbat.entity.User;
import com.yk.cbat.util.PageUtil;

import java.util.List;

/**
 * Created by JohenTeng on 2017/8/31.
 */
public interface UserService extends CommonService {

    List<User> getUserByPage(PageUtil<User> page);
}
