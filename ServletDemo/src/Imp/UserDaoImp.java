package Imp;

import Bean.User;
import DB.DBUtil;
import Dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    @Override
    public  boolean getUserByName(String username,String password) {
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select username,password from user";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句
            String user = null;
            String pwd = null;
            while(rs.next()){
                user = rs.getString("username");//从数据库中查出的用户名
                pwd = rs.getString("password");//查出的密码
                if(user.equals(username)&&pwd.equals(password)){//验证成功，返回true
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String username = user.getUserName();
            if(username.equals("")||username == null){
                return false;
            }
            String sql = "insert into user(username,password,nickname) values(?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getNickName());
            int affectedRows = ps.executeUpdate();//执行sql语句
            if(affectedRows>0){//受影响行数大于0，添加成功
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;//否则返回false
    }

    @Override
    public boolean findUser(String username) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select username from user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if(username.equals(rs.next())){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPassed(String firstPwd,String secondPwd) {
        if(firstPwd.equals(secondPwd)){
            return true;
        }
        return false;
    }
}
