package com.Dao.Imp;

import com.DB.DBUtil;
import com.Dao.BillDao;
import com.JavaBean.Bill;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BillDaoImp implements BillDao {

    @Override
    public List<Bill> queryByName(String name) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_name = ?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();//执行sql语句
//            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> queryByPro(String proName) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_pprovider = ?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,proName);
            ResultSet rs = ps.executeQuery();//执行sql语句
 //            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> queryByIsPay(String isPay) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_isPay = ?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,isPay);
            ResultSet rs = ps.executeQuery();//执行sql语句
            //            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> queryByNameAndPro(String name, String proName) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_name = ? and bill_provider=?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,name);
            ps.setString(2,proName);
            ResultSet rs = ps.executeQuery();//执行sql语句
            //            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> queryByNameAndIsPay(String name, String isPay) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_name = ? and bill_isPay=?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,name);
            ps.setString(2,isPay);
            ResultSet rs = ps.executeQuery();//执行sql语句
//            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> queryByProAndIsPay(String proName, String isPay) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_provider = ? and bill_isPay=?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,proName);
            ps.setString(2,isPay);
            ResultSet rs = ps.executeQuery();//执行sql语句
//            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public List<Bill> queryByThree(String name, String proName, String isPay) {
        List<Bill> billList = new ArrayList<>();
        try {
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills where bill_name=? and bill_provider = ? and bill_isPay=?";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ps.setString(1,name);
            ps.setString(2,proName);
            ps.setString(3,isPay);
            ResultSet rs = ps.executeQuery();//执行sql语句
//            遍历结果集
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public boolean addBill(Bill bill) {
//        连接数据库
        try {
            Connection conn = DBUtil.getConn();
            String sql = "insert into bills values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bill.getBill_id());
            ps.setString(2,bill.getBill_name());
            ps.setString(3,bill.getBill_unit());
            ps.setString(4,bill.getBill_amount());
            ps.setString(5,bill.getBill_money());
            ps.setString(6,bill.getBill_provider());
            ps.setString(7,bill.getBill_isPay());
            Calendar c = Calendar.getInstance();//获取当前时间
            ps.setString(8,c.getTime().toString());
            int update = ps.executeUpdate();
            System.out.println("data:"+bill.toString());
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
    public List<Bill> showAllBill() {
        List<Bill> billList = new ArrayList<>();
        try{
//          连接数据库
            Connection conn  = DBUtil.getConn();//获取连接
            String sql = "select * from bills";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
//                创建订单，保存结果集中的数据
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("bill_id"));
                bill.setBill_name(rs.getString("bill_name"));
                bill.setBill_unit(rs.getString("bill_unit"));
                bill.setBill_amount(rs.getString("bill_amount"));
                bill.setBill_money(rs.getString("bill_money"));
                bill.setBill_provider(rs.getString("bill_provider"));
                bill.setBill_isPay(rs.getString("bill_isPay"));
                bill.setBill_time(rs.getString("bill_time"));
                billList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public boolean updateBill(Bill bill) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "update bills set bill_name=?,bill_unit=?,bill_amount=?,bill_money=?,bill_provider=?,bill_isPay=?,bill_time=?where bill_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,bill.getBill_name());
            ps.setString(2,bill.getBill_unit());
            ps.setString(3,bill.getBill_amount());
            ps.setString(4,bill.getBill_money());
            ps.setString(5,bill.getBill_provider());
            ps.setString(6,bill.getBill_isPay());
            Calendar c = Calendar.getInstance();
            String date = c.getTime().toString();
            ps.setString(7,date);
            ps.setInt(8,bill.getBill_id());
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
    public boolean deleteBill(int billId) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "delete from bills where bill_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,billId);
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
