package com.Dao;

import com.JavaBean.Student;

import java.util.List;

public interface StuDao {
//    增加
    boolean insertStu(Student stu);
//    修改
    boolean updateStu(Student student);
//    删除
    List<Student> delStu(String name);
//    查看所有
    List<Student> QueryAll();
//    按编号搜索
    List<Student> queryById(int id);
//    按姓名搜索
    List<Student> queryByName(String name);
//    按年龄搜索
    List<Student> queryByAge(int age);
//    按班级搜索
    List<Student> queryByClass(String clazz);
//    按专业搜索
    List<Student> queryByMajor(String major);
}
