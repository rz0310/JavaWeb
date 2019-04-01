package com.Dao;

import com.JavaBean.UserBean;

public interface UserDao {
    UserBean getUser(String userName);
    boolean register(UserBean userBean);
}
