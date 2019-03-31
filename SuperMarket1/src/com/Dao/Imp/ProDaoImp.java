package com.Dao.Imp;

import com.DB.DBUtil;
import com.Dao.ProDao;
import com.JavaBean.Bill;
import com.JavaBean.Provider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProDaoImp implements ProDao {

    @Override
    public List<Provider> queryByName(String name) {
        List<Provider> providerList = new ArrayList<>();
        //        获取数据库连接
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select * from provider where pro_name like '%"+name+"%';";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Provider provider = new Provider();
                provider.setPro_id(rs.getInt("pro_id"));
                provider.setPro_name(rs.getString("pro_name"));
                provider.setPro_conn(rs.getString("pro_conn"));
                provider.setPro_tel(rs.getString("pro_tel"));
                provider.setPro_add(rs.getString("pro_add"));
                provider.setPro_fax(rs.getString("pro_fax"));
                provider.setPro_desc(rs.getString("pro_desc"));
//                获取当前时间
                Calendar c = Calendar.getInstance();
                String time = c.getTime().toString();
                provider.setPro_time(time);
                providerList.add(provider);
            }
            System.out.println(providerList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return providerList;
    }

    @Override
    public boolean addPro(Provider provider) {
//        获取数据库连接
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "insert into provider values(?,?,?,?,?,?,?,?);";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setInt(1,provider.getPro_id());
            ps.setString(2,provider.getPro_name());
            ps.setString(3,provider.getPro_conn());
            ps.setString(4,provider.getPro_tel());
            ps.setString(5,provider.getPro_add());
            ps.setString(6,provider.getPro_fax());
            ps.setString(7,provider.getPro_desc());
            Calendar c = Calendar.getInstance();//获取当前时间
            String time = c.getTime().toString();
            ps.setString(8,time);
            int update = ps.executeUpdate();//执行sql语句，获得结果集
            if(update>0){//受影响行数大于0
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
    public List<Provider> showAllPro() {
        List<Provider> proList = new ArrayList<>();//集合保存所有供应商
//        获取数据库连接
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select * from provider;";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句
            while(rs.next()){
                Provider provider = new Provider();
                provider.setPro_id(rs.getInt("pro_id"));
                provider.setPro_name(rs.getString("pro_name"));
                provider.setPro_conn(rs.getString("pro_conn"));
                provider.setPro_tel(rs.getString("pro_tel"));
                provider.setPro_add(rs.getString("pro_add"));
                provider.setPro_fax(rs.getString("pro_fax"));
                provider.setPro_desc(rs.getString("pro_desc"));
                provider.setPro_time(rs.getString("pro_time"));
                proList.add(provider);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public boolean updatePro(Provider provider) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "update provider set pro_name=?,pro_conn=?,pro_tel=?,pro_add=?,pro_fax=?,pro_desc=?,pro_time=? where pro_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,provider.getPro_name());
            ps.setString(2,provider.getPro_conn());
            ps.setString(3,provider.getPro_tel());
            ps.setString(4,provider.getPro_add());
            ps.setString(5,provider.getPro_fax());
            ps.setString(6,provider.getPro_desc());
            ps.setString(7,provider.getPro_time());
            ps.setInt(8,provider.getPro_id());
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
    public boolean deletePro(int id) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "delete from provider where pro_id=?";
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
