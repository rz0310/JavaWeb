package com.Dao.Imp;

import com.DB.DBUtil;
import com.Dao.UserDao;
import com.JavaBean.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserDaoImp implements UserDao {

    @Override
    public List<User> queryUser(String name) {
        List<User> userList = new ArrayList<>();//集合保存所有供应商
//        获取数据库连接
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select * from user where user_name like '%"+name+"%';";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_birth(rs.getString("user_birth"));
                user.setUser_add(rs.getString("user_add"));
                user.setUser_age(rs.getString("user_age"));
                user.setUser_tel(rs.getString("user_tel"));
                user.setUser_type(rs.getString("user_type"));
                userList.add(user);
            }
            System.out.println(userList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> showAllUser() {
        List<User> userList = new ArrayList<>();//集合保存所有供应商
//        获取数据库连接
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select * from user;";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_age(rs.getString("user_age"));
                user.setUser_tel(rs.getString("user_tel"));
                user.setUser_type(rs.getString("user_type"));
                user.setUser_birth(rs.getString("user_birth"));
                user.setUser_add(rs.getString("user_add"));
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean addUser(User user) {
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?);";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setInt(1,user.getUser_id());
            ps.setString(2,user.getUser_name());
            ps.setString(3,user.getUser_pwd());
            ps.setString(4,user.getUser_pwd2());
            ps.setString(5,user.getUser_sex());
            ps.setString(6,user.getUser_birth());
            ps.setString(7,user.getUser_tel());
            ps.setString(8,user.getUser_add());
            ps.setString(9,user.getUser_type());
            ps.setString(10,user.getUser_age());
            Calendar c = Calendar.getInstance();
            ps.setString(11,c.getTime().toString());
            int update = ps.executeUpdate();//执行sql语句
            if(update>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "update user set user_name=?,user_sex=?,user_birth=?,user_tel=?,user_add=?,user_type=? where user_id=?;";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,user.getUser_name());
            ps.setString(2,user.getUser_sex());
            ps.setString(3,user.getUser_birth());
            ps.setString(4,user.getUser_tel());
            ps.setString(5,user.getUser_add());
            ps.setString(6,user.getUser_type());
            ps.setInt(7,user.getUser_id());
            int update = ps.executeUpdate();//执行sql语句
            if(update>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "delete from user where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int update = ps.executeUpdate();
            if(update>0){
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
