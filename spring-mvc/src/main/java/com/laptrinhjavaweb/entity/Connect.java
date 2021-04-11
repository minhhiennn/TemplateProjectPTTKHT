package com.laptrinhjavaweb.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=CourseRegistration;",
						"sa", "sa");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return connection;
		} else {
			return connection;
		}
	}
	
	//Test connection
	public static void main(String[] args) throws SQLException {
		Connection connection = Connect.getConnection();
		if(connection != null) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
}
