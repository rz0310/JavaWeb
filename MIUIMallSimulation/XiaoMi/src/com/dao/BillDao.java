package com.dao;

import com.bean.Bill;

import java.util.ArrayList;
import java.util.List;

public interface BillDao {
    //(1)订单增加
    boolean addBill(Bill bill);
    //(2)订单删除
    boolean deleteBill(String id);
    //(3)订单修改
    boolean updateBill(Bill bill);
    //(4)订单查询(根据订单号模糊查询)
    ArrayList<Bill> getAllBill();
    //(5)订单搜索(根据订单号模糊查询)
    ArrayList<Bill> getLikesBill(String billId);

    // 根据订单号查询订单
    Bill getBillById(String billId);

    /*
     * 返回数据需要显示的 总页数
     *
     */
    int getCountPages();

    List<Bill> getBillByPage(int diPage);

    //(5)订单搜索
    List<Bill> getBill(String billId);
}
