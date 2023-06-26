package com.loginproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginproject.dao.Sql;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Sql sql = new Sql();

		try {
			ResultSet rs=sql.displayData();
			out.println("Displaying all the details of all employees");
			while (rs.next()) {
				out.println(rs.getString(1) + ":" + rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.getWriter().close();
	}

}
