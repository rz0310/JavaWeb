package com.Dao.Imp;

import com.db.DBUtil;
import com.Dao.UserDao;
import com.JavaBean.UserBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    @Override
    public UserBean getUser(String userName) {
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select username,password from user where username=?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();//执行sql语句，获取结果集
            while(rs.next()){
                UserBean userBean = new UserBean();
                userBean.setUserName(rs.getString("username"));
                userBean.setPassWord(rs.getString("password"));
                return userBean;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(UserBean userBean) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "insert into user(username,password) values(?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,userBean.getUserName());
            ps.setString(2,userBean.getPassWord());
            int register = ps.executeUpdate();
            if(register>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
