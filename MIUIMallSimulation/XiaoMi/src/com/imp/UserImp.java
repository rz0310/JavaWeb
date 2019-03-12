package com.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.util.DBUtil;
/**
 * 
 * @author liangqi
 * @desc 用户的登陆 和 注册 的操作
 */
public class UserImp implements UserDao{
	public static final int RECORDS = 5;//定义每个页面显示5条记录


	//(1)用户名密码确认（登陆确认）：
	@Override
	public Boolean loginCheck(String userName, String password) {
		//获取数据库操作对象
		DBUtil db = DBUtil.getDBUtil();
        String sql = "select password from users where username = '" + userName + "'";
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                return password.equals(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
	//(2)用户注册：
	@Override
	public Boolean register(User user) {
		//数据库操作
		DBUtil db = DBUtil.getDBUtil();
		//创建inset sql语句
		String sql = "insert into users values('"+ user.getUserName() +"','"+ user.getPassword()+"','"+ user.getPhone()+"','"+ user.getSign()+"','"+ user.getAddress()+"')";
		System.out.println(sql);
		if(db.executeUpdate(sql) > 0) {
			return true;
		}
		return false;
	}
	//(3)判断密码和确认密码是否一致：
	@Override
	public Boolean isSame(String password, String rePassword) {
		return password.equals(rePassword);
	}
	//(4)用户更新：
	@Override
	public Boolean update(User user) {
		//进行数据库操作
		DBUtil db = DBUtil.getDBUtil();
		String sql = "Update users set username=" + user.getUserName() + ",password=" + user.getPassword() + ",phone="
				+ user.getPhone() + ",sign=" + user.getSign() + ",address=" + user.getAddress() +"where username=" + user.getUserName();
		if(db.executeUpdate(sql) > 0) {
			return true;
		}
		return false;
	}
	//(5)用户删除（根据用户名在数据库里删除）：
	@Override
	public Boolean delete(String userName) {
		//进行数据库操作对象
		DBUtil db = DBUtil.getDBUtil();
		String sql = "delete from users where username = " + userName;
		int i = db.executeUpdate(sql);
		if(i>0) {
			return true;
		}
		return false;
	}
	//(6)用户查询（查询所有）：
	@Override
	public ArrayList<User> getAllUser() {
		//创建ArraysList集合存放所有的用户对象
		ArrayList<User> allUser = new ArrayList<User>();
		// 进行数据库操作对象
		DBUtil db = DBUtil.getDBUtil();
		String sql = "select * from users";
		ResultSet res = db.executeQuery(sql);
		//进行数据的封装
		try {
			while(res.next()) {
				User user = new User();
				user.setUserName(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setPhone(res.getString("phone"));
				user.setAddress(res.getString("address"));
				user.setSign(res.getString("sign"));
				allUser.add(user);
			}
			return allUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//(7)用户搜索（根据用户名模糊查询）
	@Override
	public ArrayList<User> getLikesUser(String userName) {
		//创建集合存放查询结果
		ArrayList<User> likesUserList = new ArrayList<User>();
		// 进行数据库操作对象
		DBUtil db = DBUtil.getDBUtil();
		String sql = "SELECT * FROM users WHERE userName LIKE '%"+userName+"%'";
		ResultSet res = db.executeQuery(sql);
		
		// 进行数据的封装
		try {
			while (res.next()) {
				User user = new User();
				user.setUserName(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setPhone(res.getString("phone"));
				user.setAddress(res.getString("address"));
				user.setSign(res.getString("sign"));
				likesUserList.add(user);
			}
			return likesUserList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUserName(String username) {
		DBUtil db = DBUtil.getDBUtil();
		String sql = "select * from users where userName = '" + username + "';";
		ResultSet rs = db.executeQuery(sql);
		User user = new User();
		try {
			if (rs.next()) {
				user.setUserName(username);
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setSign(rs.getString("sign"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateInfo(String item, String content, String username) {
		String sql = "update users set " + item + "='" + content + "' where userName = '"+username+"'";
		DBUtil db = DBUtil.getDBUtil();
		int i = db.executeUpdate(sql);
		if (i > 0) {
			return true;
		}
		return true;
	}

	//(8)获取页面数量
	@Override
	public int getCountPages() {
		int recordsCounts = 0;//定义总的记录数
		int pageCounts = 0;//定义页面数量

		try {
			// 获取所有的账单记录的结果集
			DBUtil db = DBUtil.getDBUtil();
			String sql = "select count(userName) from users";
			ResultSet res = db.executeQuery(sql);
			//让结果集的游标指向最后一行
			res.last();
			//获取总的记录数
			recordsCounts = res.getInt(1);
			//计算要显示的总页数
			pageCounts = (int)Math.ceil((double)recordsCounts / RECORDS);
			return pageCounts;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//(9)获取要展示的每一页的数据
	@Override
	public ArrayList<User> getBillByPage(int diPage) {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			// 获取所有的账单记录的结果集
			DBUtil db = DBUtil.getDBUtil();
			String sql = "select * from users limit ?,"+RECORDS;
			PreparedStatement ps = db.getPs(sql);
			//给占位符赋值
			ps.setInt(1, (diPage-1)*RECORDS);
			ResultSet res = ps.executeQuery();

			//把结果集封装为List集合。
			while(res.next()) {
				//获取订单记录，进行封装
				User user = new User();
				user.setUserName(res.getString(1));
				user.setPassword(res.getString(2));
				user.setPhone(res.getString(3));
				user.setSign(res.getString(4));
				user.setAddress(res.getString(5));
				userList.add(user);
			}
			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
