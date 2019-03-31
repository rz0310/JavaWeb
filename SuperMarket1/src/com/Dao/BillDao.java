package com.Dao;

import com.JavaBean.Bill;

import java.util.List;

public interface BillDao {
    List<Bill> queryByName(String name);
    List<Bill> queryByPro(String proName);
    List<Bill> queryByIsPay(String isPay);
    List<Bill> queryByNameAndPro(String name,String proName);
    List<Bill> queryByNameAndIsPay(String name,String isPay);
    List<Bill> queryByProAndIsPay(String proName,String isPay);
    List<Bill> queryByThree(String name,String proName,String isPay);
    boolean addBill(Bill bill);
    List<Bill> showAllBill();
    boolean updateBill(Bill bill);
    boolean deleteBill(int billId);
}
