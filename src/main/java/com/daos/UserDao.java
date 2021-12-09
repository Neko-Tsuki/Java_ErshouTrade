package com.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.beans.User;
import com.utils.C3P0Utils;


@SuppressWarnings("unused")
public class UserDao {
	//添加用户
	public static int addUser(User user) {
		int i=0;
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "insert into user values(null,?,?)";
		try {
			i = queryRunner.update(conn,sql,user.getName(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!PLEASE ADD 'USER'");
		}
		C3P0Utils.closeAll(conn);
		return i;
	}
	
	//删除用户
	public static int delUser(User user) {
		int i=0;
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "delete from user where name=? and password=?";
		try {
			i = queryRunner.update(conn,sql,user.getName(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!PLEASE ADD 'USER'");
		}
		C3P0Utils.closeAll(conn);
		return i;
	}
	
	//修改用户信息
	public static int updateUser(String userName,User user) {
		int i=0;
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "update user set name=? where name=? and password=?";
		try {
			i = queryRunner.update(conn,sql,userName,user.getName(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!PLEASE ADD 'USER'");
		}
		C3P0Utils.closeAll(conn);
		return i;
	}
	
	//查询用户
	public List<User> selUser() {
		List<User> list = new ArrayList<User>();
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "select * from user";
		try {
			list = queryRunner.query(conn, sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		C3P0Utils.closeAll(conn);
		return list;
	}
	
	//查询用户（详细）
	public User sel_preUser(User user) {
		//List<User> list = new ArrayList<User>();
		User user2 = null;
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "select * from user where name=? and password=?";
		try {
			user2 = queryRunner.query(conn, sql, new BeanHandler<User>(User.class),user.getName(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		C3P0Utils.closeAll(conn);
		return user2;
	}
	
	//按Id查询
	public User selectUserByID(int id){
		User user = null;
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from user where id=?";
		Connection connection = C3P0Utils.getCon();
		try {
			user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		C3P0Utils.closeAll(connection);
		return user;
	}
}