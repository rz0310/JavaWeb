package com.imp;

import com.bean.Goods;
import com.dao.GoodsDao;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsImp implements GoodsDao {

    @Override
    public Boolean addGoods(Goods goods) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "insert into goods (goods_name,goods_img,goods_price,goods_num,goods_desc,goods_version,goods_color,goods_type,goods_paid) " +
                "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setString(1, goods.getName());
            ps.setString(2, goods.getImg());
            ps.setDouble(3, goods.getPrice());
            ps.setInt(4, goods.getNum());
            ps.setString(5, goods.getDesc());
            ps.setString(6, goods.getVersion());
            ps.setString(7, goods.getColor());
            ps.setInt(8,goods.getType());
            ps.setInt(9, goods.getPaid());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Boolean update(Goods goods) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "update goods set goods_name=?,goods_img=?,goods_price=?,goods_num=?,goods_desc=?,goods_version=?,goods_color=?,goods_type=?,goods_paid=? where goods_id = "+goods.getId();
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setString(1, goods.getName());
            ps.setString(2, goods.getImg());
            ps.setDouble(3, goods.getPrice());
            ps.setInt(4, goods.getNum());
            ps.setString(5, goods.getDesc());
            ps.setString(6, goods.getVersion());
            ps.setString(7, goods.getColor());
            ps.setInt(8, goods.getType());
            ps.setInt(9, goods.getPaid());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(int goodsId) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "delete from goods where goods_id = " + goodsId;
        if (db.executeUpdate(sql)>0) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Goods> getAllGoods() {
        DBUtil db = DBUtil.getDBUtil();
        ArrayList<Goods> arr = new ArrayList<>();
        ResultSet rs = db.executeQuery("select * from goods");
        try {
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("goods_id"));
                goods.setName(rs.getString("goods_name"));
                goods.setImg(rs.getString("goods_img"));
                goods.setNum(rs.getInt("goods_num"));
                goods.setColor(rs.getString("goods_color"));
                goods.setPrice(rs.getDouble("goods_price"));
                goods.setVersion(rs.getString("goods_version"));
                goods.setType(rs.getInt("goods_type"));
                goods.setPaid(rs.getInt("goods_paid"));
                arr.add(goods);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Goods> getLikesGoods(String goodsType) {
        DBUtil db = DBUtil.getDBUtil();
        ResultSet resultSet = db.executeQuery("select type_id from type where type_name = '" + goodsType + "';");
        int type = 0;
        try {
            if (resultSet.next()) {
                type = resultSet.getInt("type_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Goods> arr = new ArrayList<>();
        ResultSet rs = db.executeQuery("select * from goods where goods_type = "+type);
        try {
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("goods_id"));
                goods.setName(rs.getString("goods_name"));
                goods.setImg(rs.getString("goods_img"));
                goods.setNum(rs.getInt("goods_num"));
                goods.setColor(rs.getString("goods_color"));
                goods.setPrice(rs.getDouble("goods_price"));
                goods.setVersion(rs.getString("goods_version"));
                goods.setType(rs.getInt("goods_type"));
                goods.setPaid(rs.getInt("goods_paid"));
                arr.add(goods);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double getPriceByName(String name) {
        String sql = "select goods_price from goods where goods_name = '" + name + "'";
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getDouble("goods_price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getEvaluateByName(String name) {
        String sql = "select * from evaluate where goods_name = '" + name + "'";
        DBUtil db = DBUtil.getDBUtil();
        int temp = 0;
        ResultSet rs = db.executeQuery(sql);
        try {
            rs.last();
            int row = rs.getRow();
            temp = (int) (1+Math.random() * row);
            if (rs.absolute(temp)) {
                return rs.getString("user_name")+":"+rs.getString("content");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods getGoodsById(int goods_id) {
        String sql = "select * from goods where goods_id = " + goods_id;
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery(sql);
        Goods goods = new Goods();
        try {
            if (rs.next()) {
                goods.setId(goods_id);
                goods.setVersion(rs.getString("goods_version"));
                goods.setName(rs.getString("goods_name"));
                goods.setImg(rs.getString("goods_img"));
                goods.setColor(rs.getString("goods_color"));
                goods.setNum(rs.getInt("goods_num"));
                goods.setPrice(rs.getDouble("goods_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public int getIdByNameAndVersion(String name, String version) {
        String sql = "select goods_id from goods where goods_name='" + name + "' and goods_version='" + version + "';";
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                int goods_id = rs.getInt("goods_id");
                return goods_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public ArrayList<Goods> getByName(String name) {
        ArrayList<Goods> goodsList = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from goods where goods_name = '"+name+"';";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Goods good = new Goods();
                good.setColor(rs.getString("goods_color"));
                good.setId(rs.getInt("goods_id"));
                good.setImg(rs.getString("goods_img"));
                good.setName(rs.getString("goods_name"));
                good.setNum(rs.getInt("goods_num"));
                good.setPrice(rs.getDouble("goods_price"));
                good.setVersion(rs.getString("goods_version"));
                good.setDesc(rs.getString("goods_desc"));
                goodsList.add(good);
            }
            System.out.println(goodsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }
}
