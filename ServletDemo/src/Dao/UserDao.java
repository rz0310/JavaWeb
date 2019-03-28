package Dao;

import Bean.User;

public interface UserDao {
//    根据名字获取用户名
    public abstract boolean getUserByName(String username,String password);
//    添加用户
    public abstract boolean addUser(User user);//添加用户
//    查询用户是否存在
    public abstract boolean findUser(String username);
    public abstract boolean isPassed(String firstPwd,String secondPwd);
}
