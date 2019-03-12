package com.dao;

import com.bean.Carts;
import java.util.ArrayList;
import java.util.HashMap;

public interface CartDao {
    // 删除
    boolean delete(int id);

    // 修改
    boolean update(int id, int num);

    // 插入
    boolean insert(Carts carts);

    // 获取所有
    ArrayList<Carts> getAll();

//    根据总数据条数判断显示的总页数
    public int getTotalPages(ArrayList<Carts> cartsList);
}