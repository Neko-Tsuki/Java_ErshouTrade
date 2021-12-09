package com.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("intergalactoApp");
	}
	
	public static Connection getCon() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeAll(Connection connection) {
		try {
			if (connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		System.out.print(C3P0Utils.getCon());
	}

}
