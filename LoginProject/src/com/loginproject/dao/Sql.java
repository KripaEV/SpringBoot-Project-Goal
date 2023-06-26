package com.loginproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.loginproject.dto.Employee;

public class Sql {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean userLogin(Employee e) throws SQLException, ClassNotFoundException {
		String query = "Select * from emp where emp_name=? and pass=?";
		con = Connect.getPostGresConnection();

		ps = con.prepareStatement(query);
		ps.setString(1, e.getName());
		ps.setString(2, e.getPswd());

		rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean checkUser(Employee e) throws SQLException, ClassNotFoundException {
		String query = "Select * from emp where emp_name=? and email=?";
		con = Connect.getPostGresConnection();

		ps = con.prepareStatement(query);
		ps.setString(1, e.getName());

		rs = ps.executeQuery();

		if (!rs.next()) {
			return true;
		}
		return false;
	}

	public String[] viewDetails(Employee e) throws SQLException, ClassNotFoundException {
		String data[] = null;
		int count = 0;
		con = Connect.getPostGresConnection();

		String query = "select * from emp where emp_name=? and pass=?";

		ps = con.prepareStatement(query);
		ps.setString(1, e.getName());
		ps.setString(2, e.getPswd());

		rs = ps.executeQuery();
		count = rs.getMetaData().getColumnCount();

		while (rs.next()) {
			data = new String[count];
			for (int i = 0; i < count; i++) {
				data[i] = rs.getString(i + 1);
			}
		}
		con.close();
		return data;
	}

	public ResultSet displayData() throws SQLException, ClassNotFoundException {
		con = Connect.getPostGresConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp");
		return rs;
	}
}
