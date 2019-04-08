package com.dao;

import com.bean.Goods;
import java.util.ArrayList;

public interface GoodsDao {
    //(1)商品增加
    Boolean addGoods(Goods goods);

    //(2)商品修改
    Boolean update(Goods goods);

    //(3)商品删除
    Boolean delete(int goodsId);

    //(4)商品查询
    ArrayList<Goods> getAllGoods();

    //(5)商品搜索
    ArrayList<Goods> getLikesGoods(String goodsType);

    //(6)根据商品名查询价格和随机一条评价记录
    double getPriceByName(String name);

    //(7)根据商品名查询随机一条评价记录
    String getEvaluateByName(String name);

    //(8)
    Goods getGoodsById(int goods_id);

    //(9)根据名字和版本查询id
    int getIdByNameAndVersion(String name, String vision);
    // 根据名字查
    ArrayList<Goods> getByName(String name);
}
