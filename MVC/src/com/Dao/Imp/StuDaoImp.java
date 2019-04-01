package com.Dao.Imp;

import com.DB.DBUtil;
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
    @Override
    public boolean insertStu(Student stu) {
        try {
            Connection conn = DBUtil.getConn();
            int id = stu.getId();
            String name = stu.getName();
            int age = stu.getAge();
            String clazz = stu.getClazz();
            String major = stu.getMajor();
            String image = stu.getImage();
            String sql = "insert into stu values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setString(4,clazz);
            ps.setString(5,major);
            ps.setString(6,image);
            int affectedRows = ps.executeUpdate();
            if(affectedRows>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStu(Student student) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "update stu set name=?,age=?,class=?,major=?,image='' where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getClazz());
            ps.setString(4,student.getMajor());
            ps.setInt(5,student.getId());
            int update = ps.executeUpdate();
            if(update>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//    删除
    @Override
    public List<Student> delStu(String name) {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "delete from stu where name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            int update = ps.executeUpdate();
            if(update>0){
                list = QueryAll();
                return list;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> QueryAll() {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from stu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setClazz(rs.getString("class"));
                stu.setMajor(rs.getString("major"));
                stu.setImage(rs.getString("image"));
                list.add(stu);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> queryById(int id) {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from stu where id like '%"+id+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClazz(rs.getString("class"));
                student.setMajor(rs.getString("major"));
                student.setImage(rs.getString("image"));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> queryByName(String name) {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from stu where name like '%"+name+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClazz(rs.getString("class"));
                student.setMajor(rs.getString("major"));
                student.setImage(rs.getString("image"));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> queryByAge(int age) {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from stu where age like '%"+age+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClazz(rs.getString("class"));
                student.setMajor(rs.getString("major"));
                student.setImage(rs.getString("image"));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> queryByClass(String clazz) {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from stu where class like '%"+clazz+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClazz(rs.getString("class"));
                student.setMajor(rs.getString("major"));
                student.setImage(rs.getString("image"));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> queryByMajor(String major) {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from stu where major like '%"+major+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClazz(rs.getString("class"));
                student.setMajor(rs.getString("major"));
                student.setImage(rs.getString("image"));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
