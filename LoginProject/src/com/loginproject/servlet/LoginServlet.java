package com.loginproject.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginproject.dao.Sql;
import com.loginproject.dto.Employee;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		Sql sql = new Sql();
		String[] data = null;
		HttpSession session = request.getSession();
		emp.setName(request.getParameter("username"));
		emp.setPswd(request.getParameter("password"));

		try {
			if (sql.userLogin(emp)) {
				data = sql.viewDetails(emp);
				emp.setName(data[0]);
				session.setAttribute("name", emp.getName());
				session.setAttribute("password", emp.getPswd());
				getServletContext().getRequestDispatcher("/showUsers").forward(request, response);
			} else {
				response.sendRedirect("errorPage.jsp");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
