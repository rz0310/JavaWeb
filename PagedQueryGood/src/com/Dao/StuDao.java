package com.Dao;

import com.JavaBean.Student;

import java.util.List;

public interface StuDao {
    int getTotalPage();
    List<Student> getStuByPage(int page);
}
