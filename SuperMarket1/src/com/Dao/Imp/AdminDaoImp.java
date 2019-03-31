package com.Dao.Imp;

import com.DB.DBUtil;
import com.Dao.AdminDao;
import com.JavaBean.Admin;
import com.JavaBean.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImp implements AdminDao {
    @Override
    public boolean modifyPwd(Admin admin,String newPassword) {
        try {
//            获取数据库连接
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "update admin set password=? where username = ?;";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,newPassword);
            ps.setString(2,admin.getUsername());
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
    @Override
    public boolean queryAdmin(String name,String password) {
        List<Admin> adminList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select password from admin where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()&&password.equals(rs.getString("password"))){
                return true;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
