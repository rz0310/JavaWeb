package Imp;

import Bean.Student;
import DB.DBUtil;
import Dao.StuDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDaoImp implements StuDao {
    @Override
    public List getAll() {
        List<Student> list = new ArrayList<>();//声明集合用来保存学生对象
        try {
            Connection conn = DBUtil.getConn();//获取连接
            String sql = "select id,name,age,class,major from stu";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句
            while(rs.next()){//遍历结果集
                Student s = new Student();
//                分别从结果击中获取学生对象的各个属性
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setClazz(rs.getString("class"));
                s.setMajor(rs.getString("major"));
                list.add(s);//将学生对象添加到集合
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;//返回集合
    }
}
