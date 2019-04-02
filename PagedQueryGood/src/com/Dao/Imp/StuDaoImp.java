package com.Dao.Imp;

import com.db.DBUtil;
import com.Dao.StuDao;
import com.JavaBean.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDaoImp implements StuDao {
//  使用常量定义每页要显示的行数
    public static final int PAGENUM=4;
    @Override
    public int getTotalPage() {
        int totalNum=0;//总数据量
        int totalPage=0;//总页数
        try {
            Connection conn = DBUtil.getConn();
//            select count(id) as countId from stu;
            PreparedStatement ps = conn.prepareStatement("select count(id) from stu;");
            ResultSet rs = ps.executeQuery();
            rs.next();
            totalNum = rs.getInt(1);//获取的是第一列的值
//            根据总数据量计算总页数
            totalPage = (int) Math.ceil((double)totalNum/PAGENUM);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPage;
    }

    @Override
    public List<Student> getStuByPage(int page) {
        List<Student> stuList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement("select * from stu limit ?,?;");//第一个占位符为开始的行数（不包括当前行），第二个占位符为总共显示的行数
            ps.setInt(1,(page-1)*PAGENUM);//下一页的第一行数据为当前页的最后一行的下一个，不包括当前行
            ps.setInt(2,PAGENUM);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(Integer.valueOf(rs.getString("age")));
                student.setClazz(rs.getString("class"));
                student.setMajor(rs.getString("major"));
                student.setImage(rs.getString("image"));
                stuList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stuList;
    }
}
