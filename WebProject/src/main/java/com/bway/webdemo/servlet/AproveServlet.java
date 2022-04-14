package com.bway.webdemo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bway.webdemo.model.Student;
import com.bway.webdemo.service.StudentService;
import com.bway.webdemo.service.StudentServiceimpl;
import com.bway.webdemo.service.UserService;
import com.bway.webdemo.service.UserServiceimpl;

import dbConn.Dbconn;

/**
 * Servlet implementation class AproveServlet
 */
@WebServlet("/AproveServlet")
public class AproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AproveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("id", id);
		UserService us = new UserServiceimpl();
		us.aprovedUser(id);
		List<Student> list = us.getAproveList();

		for (Student s : list) {
          request.setAttribute("name", s.getName());
			Connection con = Dbconn.getconn();
			try {
				Statement stm = con.createStatement();
				String sql = "INSERT INTO `webdb`.`student2` (`name`, `email`, `password`, `gender`, `dob`, `textarea`, `city`, `state`, `country`, `phone`) VALUES ('"
						+ s.getName() + "', '" + s.getEmail() + "', '" + s.getPassword() + "', '" + s.getGender()
						+ "', '" + s.getDob() + "', '" + s.getTextarea() + "', '" + s.getCity() + "', '" + s.getState()
						+ "', '" + s.getCountry() + "', '" + s.getPhone() + "');";
				stm.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
         request.setAttribute("message", "is aproved");
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
