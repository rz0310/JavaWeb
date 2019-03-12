package com.imp;

import com.bean.Carts;
import com.dao.CartDao;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CartImp implements CartDao {
    @Override
    public boolean delete(int id) {
        String sql = "delete from carts where carts_id = " + id;
        DBUtil db = DBUtil.getDBUtil();
        int i = db.executeUpdate(sql);
        if (i>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(int id,int num) {
        String sql = "update carts set carts_num =" + num + " where carts_id = " + id;
        DBUtil db = DBUtil.getDBUtil();
        int i = db.executeUpdate(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(Carts carts) {
        String sql = "insert into carts(carts_id,carts_name,carts_num,carts_version,carts_color,carts_price,carts_img) values(?,?,?,?,?,?,?)";
        DBUtil db = DBUtil.getDBUtil();
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setInt(1, carts.getId());
            ps.setString(2, carts.getName());
            ps.setInt(3, carts.getNum());
            ps.setString(4,carts.getVersion());
            ps.setString(5, carts.getColor());
            ps.setDouble(6, carts.getPrice());
            ps.setString(7, carts.getImg());
            int update = ps.executeUpdate();
            if (update>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public  ArrayList<Carts> getAll() {
        ArrayList<Carts> cartsHashMap = new  ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery("select * from carts");
        try {
            while (rs.next()) {
                Carts cart = new Carts();
                cart.setColor(rs.getString("carts_color"));
                cart.setId(rs.getInt("carts_id"));
                cart.setImg(rs.getString("carts_img"));
                cart.setName(rs.getString("carts_name"));
                cart.setNum(rs.getInt("carts_num"));
                cart.setVersion(rs.getString("carts_version"));
                cart.setPrice(rs.getDouble("carts_price"));
                cartsHashMap.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartsHashMap;
    }

    @Override
    public int getTotalPages(ArrayList<Carts> cartsList) {
//        定义每页要显示的数据的行数
        int pageNum = 4;
//        获取购物车中的数据的总长度
        int size = getAll().size();
//        根据总的数据长度得到要显示的总页数
        int totalPage = (int)Math.ceil((double)size/pageNum);
        return totalPage;
    }

}
