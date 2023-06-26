package com.loginproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getPostGresConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;

		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "123";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

			System.out.println("Connecting");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
