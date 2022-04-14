package com.bway.webdemo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Dbconn;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String date = request.getParameter("date");
		String textarea = request.getParameter("textarea");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");

		if (name.isEmpty() || email.isEmpty() || password.isEmpty() || gender.isEmpty() || date.isEmpty()
				|| textarea.isEmpty() || state.isEmpty() || country.isEmpty() || phone.isEmpty()) {
			request.setAttribute("message", "Fill all the field");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			try {

				String sql = "INSERT INTO `webdb`.`user` (`name`, `email`, `password`, `gender`, `dob`, `textarea`, `city`, `state`, `country`, `phone`) VALUES ('"+name+"', '"+email+"', '"+password+"', '"+gender+"', '"+date+"', '"+textarea+"', '"+city+"', '"+state+"', '"+country+"', '"+phone+"');"; 
				Statement stmt = Dbconn.getconn().createStatement();
				stmt.execute(sql);
				request.setAttribute("message1", "Dear");
				request.setAttribute("name", name);
				request.setAttribute("message2", " you can login with your name and password when u will aproved");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
