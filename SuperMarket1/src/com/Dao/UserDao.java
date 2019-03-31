package com.Dao;

import com.JavaBean.Bill;
import com.JavaBean.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser(String name);
    List<User> showAllUser();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
