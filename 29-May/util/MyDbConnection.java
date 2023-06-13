package com.ded.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
	static Connection con;
	
private static MyDbConnection instance = null;

	private MyDbConnection() {
		
	}
	
	public static MyDbConnection getInstance() {
		if(instance == null) {
			instance = new MyDbConnection();
		}
		return instance;
	}
	
	
	public static Connection getMyConnection() {

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Moni@2001_jk");
			System.out.println(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	

	public static void main(String[] args) {
		System.out.println(getMyConnection());

	}

}
