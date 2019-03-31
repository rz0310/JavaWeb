package com.Dao;

import com.JavaBean.Admin;

public interface AdminDao {
    boolean modifyPwd(Admin admin,String newPassword);
    public boolean queryAdmin(String name,String password);
}
