package com.imp;

import com.bean.Goods;
import com.dao.GoodsDao;
import com.util.DBUtil;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsImp implements GoodsDao {

    public static final int RECORDS = 5;//定义每个页面显示5条记录


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
                return goods;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getIdByNameAndVersion(String name, String version) {
        String sql = "select goods_id from goods where goods_name='" + name + "' and goods_version='" + version + "';";
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getInt("goods_id");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    //获取页面数量
    @Override
    public int getCountPages() {
        int recordsCounts = 0;//定义总的记录数
        int pageCounts = 0;//定义页面数量

        try {
            // 获取所有的账单记录的结果集
            DBUtil db = DBUtil.getDBUtil();
            String sql = "select count(goods_id) from goods";
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
    //获取要展示的每一页的数据
    @Override
    public ArrayList<Goods> getBillByPage(int diPage) {
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        try {
            // 获取所有的账单记录的结果集
            DBUtil db = DBUtil.getDBUtil();
            String sql = "select * from goods limit ?,"+RECORDS;
            PreparedStatement ps = db.getPs(sql);
            //给占位符赋值
            ps.setInt(1, (diPage-1)*RECORDS);
            ResultSet res = ps.executeQuery();

            //把结果集封装为List集合。
            while(res.next()) {
                //获取订单记录，进行封装
                Goods goods = new Goods();
                goods.setId(res.getInt("goods_id"));
                goods.setName(res.getString("goods_name"));
                goods.setImg(res.getString("goods_img"));
                goods.setPrice(res.getDouble("goods_price"));
                goods.setNum(res.getInt("goods_num"));
                goods.setDesc(res.getString("goods_desc"));
                goods.setVersion(res.getString("goods_version"));
                goods.setColor(res.getString("goods_color"));
                goods.setType(res.getInt("goods_type"));
                goods.setPaid(res.getInt("goods_paid"));
                goodsList.add(goods);
            }
            return goodsList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
