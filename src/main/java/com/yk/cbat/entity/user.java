package com.yk.cbat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by JohenTeng on 2017/8/28.
 */
@Entity
public class user {
    private String userId;
    private String userName;
    private String userPwd;
    private String userbehavior;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserbehavior() {
        return userbehavior;
    }

    public void setUserbehavior(String userbehavior) {
        this.userbehavior = userbehavior;
    }
}
