package com.imp;


import com.bean.Bill;
import com.dao.BillDao;
import com.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillImp implements BillDao {

    public static final int RECORDS = 5;//定义每个页面显示5条记录

    @Override
    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> arr = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from bill";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getString("bill_id"));
                bill.setStatus(rs.getString("bill_status"));
                bill.setMoney(rs.getDouble("bill_money"));
                bill.setGoodsName(rs.getString("bill_goodsName"));
                bill.setGoodsPrice(rs.getInt("bill_goodsPrice"));
                bill.setGoodsNum(rs.getInt("bill_goodsNum"));
                bill.setDate(rs.getString("bill_date"));
                arr.add(bill);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Bill> getLikesBill(String billId) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from bill where goodsName like '%" + billId + "%';";
        if (billId == null) {
            sql = "select * from bill where bill_name like '%" + billId + "%';";
        }

        ResultSet rs = db.executeQuery(sql);
        ArrayList<Bill> arr = new ArrayList<>();
        try {
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getString("bill_id"));
                bill.setStatus(rs.getString("bill_status"));
                bill.setMoney(rs.getDouble("bill_money"));
                bill.setGoodsName(rs.getString("bill_goodsName"));
                bill.setGoodsPrice(rs.getDouble("bill_goodsPrice"));
                bill.setGoodsNum(rs.getInt("bill_goodsNum"));
                bill.setDate(rs.getString("bill_date"));
                arr.add(bill);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bill getBillById(String billId) {
        String sql = "select * from bill where bill_id like '%" + billId + "%';";
        if (billId == null) {
            sql = "select * from bill";
        }
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getString("bill_id"));
                bill.setStatus(rs.getString("bill_status"));
                bill.setMoney(rs.getDouble("bill_money"));
                bill.setGoodsName(rs.getString("bill_goodsName"));
                bill.setGoodsPrice(rs.getDouble("bill_goodsPrice"));
                bill.setGoodsNum(rs.getInt("bill_goodsNum"));
                bill.setDate(rs.getString("bill_date"));
                return bill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBill(Bill bill) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "insert into bills values(?,?,?,?,?,?,?);";
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setString(1,bill.getId());
            ps.setString(2,bill.getStatus());
            ps.setDouble(3, bill.getMoney());
            ps.setString(4,bill.getGoodsName());
            ps.setDouble(5,bill.getGoodsPrice());
            ps.setInt(6, bill.getGoodsNum());
            ps.setString(7, bill.getDate());
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean updateBill(Bill bill) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "Update bills set bill_goodsName='"+bill.getGoodsName()+"',bill_status='"+bill.getStatus()+"',bill_money="+bill.getMoney()+",bill_goodsNum="+bill.getGoodsNum()+",bill_goodsPrice="+ bill.getGoodsPrice()+" where bill_id="+bill.getId();
        if (db.executeUpdate(sql) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBill(String id) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "delete from bill where bill_id = '" + id + "'";
        if (db.executeUpdate(sql)>0) {
            return true;
        }
        return false;
    }

    /*
     * 返回数据需要显示的 总页数
     *
     */
    @Override
    public int getCountPages() {
        int recordsCounts = 0;//定义总的记录数
        int pageCounts = 0;//定义页面数量

        try {
            // 获取所有的账单记录的结果集
            DBUtil db = DBUtil.getDBUtil();
            String sql = "select count(bill_id) from bill";
            ResultSet res = db.executeQuery(sql);
            //让结果集的游标指向最后一行
            res.last();
            //获取总的记录数
            recordsCounts = res.getInt(1);
            //计算要显示的总页数
            pageCounts = (int)Math.ceil((double)recordsCounts / RECORDS);
            return pageCounts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * 得到每一页要显示的对应的数据
     */

    @Override
    public List<Bill> getBillByPage(int diPage) {
        ArrayList<Bill> billList = new ArrayList<Bill>();
        try {
            // 获取所有的账单记录的结果集
            DBUtil db = DBUtil.getDBUtil();
            String sql = "select * from bill limit ?,"+RECORDS;
            PreparedStatement ps = db.getPs(sql);
            //给占位符赋值
            ps.setInt(1, (diPage-1)*RECORDS);
            ResultSet res = ps.executeQuery();

            //把结果集封装为List集合。
            while(res.next()) {
                //获取订单记录，进行封装
                Bill bill = new Bill();
                bill.setId(res.getString("bill_id"));
                bill.setGoodsName(res.getString("bill_goodsName"));
                bill.setGoodsPrice(res.getDouble("bill_goodsPrice"));
                bill.setGoodsNum(res.getInt("bill_goodsNum"));
                bill.setStatus(res.getString("bill_status"));
                bill.setMoney(res.getDouble("bill_money"));
                bill.setDate(res.getString("bill_date"));
                billList.add(bill);
            }
            return billList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //(5)订单搜索
    @Override
    public List<Bill> getBill(String billId) {
        List<Bill> list= new ArrayList();
        // 获取所有的账单记录的结果集
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from bill where bill_id like '%"+billId+"%';";
        ResultSet res = db.executeQuery(sql);

        try {
            while(res.next()) {
                //获取订单记录，进行封装
                Bill bill = new Bill();
                bill.setId(res.getString("bill_id"));
                bill.setGoodsName(res.getString("bill_goodsName"));
                bill.setGoodsPrice(res.getDouble("bill_goodsPrice"));
                bill.setGoodsNum(res.getInt("bill_goodsNum"));
                bill.setStatus(res.getString("bill_status"));
                bill.setMoney(res.getDouble("bill_money"));
                bill.setDate(res.getString("bill_date"));
                list.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
