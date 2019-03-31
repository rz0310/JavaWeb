package com.Dao;

import com.JavaBean.Bill;
import com.JavaBean.Provider;

import java.util.List;

public interface ProDao {
    List<Provider> queryByName(String name);
    boolean addPro(Provider provider);
    List<Provider> showAllPro();
    boolean updatePro(Provider provider);
    boolean deletePro(int id);
}
