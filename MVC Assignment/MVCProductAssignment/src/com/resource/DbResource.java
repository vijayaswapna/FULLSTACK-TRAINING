package com.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {
private static Connection con;

	public static Connection getDbConnection() {
		// TODO Auto-generated method stub
		//return null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","9100532080");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}

}
