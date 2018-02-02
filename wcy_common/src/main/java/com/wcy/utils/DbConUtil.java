package com.wcy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConUtil {
	public static Connection getcon(){
//		Thread trd= Thread.currentThread();
		String driverClassName = ConfigerUtil.getProPerty("config/jdbc.properties","jdbc.driverClassName");
		String username = ConfigerUtil.getProPerty("config/jdbc.properties","jdbc.username");
		String password = ConfigerUtil.getProPerty("config/jdbc.properties","jdbc.password");
		String url = ConfigerUtil.getProPerty("config/jdbc.properties","jdbc.url")+"?characterEncoding=utf-8";
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeCone(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {   
		Connection conn = null;   
		String URL = "jdbc:mysql://localhost:3306/yymgc?useUnicode=true&amp;characterEncoding=utf8";   
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
		String USER_NAME = "root";   
		String PASSWORD = "123456";
		try {   
			Class.forName(JDBC_DRIVER);   
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);   
		} catch (ClassNotFoundException e) {   
			e.printStackTrace();   
		} catch (SQLException e) {   
			e.printStackTrace();   
		}   
		return conn;   
	}
 
	// 测试
	public static void main(String[] args) throws Exception {
		Connection con = getcon();
		if (con != null) {
			System.out.println("测试成功！");
		}
	}
}
