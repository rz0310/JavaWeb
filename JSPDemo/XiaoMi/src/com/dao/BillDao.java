package com.dao;

import com.bean.Bill;

import java.util.ArrayList;

public interface BillDao {
    //(1)订单增加
    Boolean addBill(Bill bill);
    //(2)订单删除
    Boolean delete(Bill bill);
    //(3)订单修改
    Boolean update(Bill bill);
    //(4)订单查询(根据订单号模糊查询)
    ArrayList<Bill> getAllBill();
    //(5)订单搜索(根据订单号模糊查询)
    ArrayList<Bill> getLikesBill(String billId);
}
