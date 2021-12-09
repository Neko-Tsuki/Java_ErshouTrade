package com.daos;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.beans.Admin;
import com.utils.C3P0Utils;

public class AdminDao {
	//查詢用戶
	QueryRunner queryRunner=new QueryRunner();
	public Admin sel_preAdmin(Admin admin) {
		Admin admin2 = null;
		Connection conn = C3P0Utils.getCon();
		String sql = "select * from admin where name=? and password=?";
		try {
			admin2 = queryRunner.query(conn, sql, new BeanHandler<Admin>(Admin.class),admin.getName(),admin.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		C3P0Utils.closeAll(conn);
		return admin2;
	}

}
