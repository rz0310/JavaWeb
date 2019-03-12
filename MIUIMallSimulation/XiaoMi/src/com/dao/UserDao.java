package com.dao;

import java.util.ArrayList;

import com.bean.User;

public interface UserDao {
    //(1)用户名密码确认（登陆确认）：
    Boolean loginCheck(String userName, String password);
    //(2)用户注册：
    Boolean register(User user);
    //(3)判断密码和确认密码是否一致：
    Boolean isSame(String password, String rePassword);
    //(4)用户更新：
    Boolean update(User user);
    //(5)用户删除（根据用户名在数据库里删除）：
    Boolean delete(String userName);
    //(6)用户查询（查询所有）：
    ArrayList<User> getAllUser();
    //(7)用户搜索（根据用户名模糊查询）
    ArrayList<User> getLikesUser(String userName);
    // 根据用户名查询用户对象
    User getUserByUserName(String username);

    // 根据用户输入更新用户信息
    boolean updateInfo(String item, String content, String username);

    //(8)获取页面数量
    int getCountPages();

    //(9)获取要展示的每一页的数据
    ArrayList<User> getBillByPage(int diPage);
}
