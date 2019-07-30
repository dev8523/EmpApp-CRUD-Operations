package com.infinite.EmpApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinite.EmpApp.service.LoginService;
import com.infinite.EmpApp.service.LoginServiceImpl;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// System.out.println("Servlet executed...");
		HttpSession httpSession = null;
		httpSession = request.getSession(false);
		LoginService loginService = LoginServiceImpl.getInstance();
		String userName = (String) httpSession.getAttribute("username");
		try {
			loginService.changeStatus(userName, 0);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response); // Don't forget to add forward method for redirecting
															// pages when using
															// RequestDispatcher
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpSession.invalidate();

	}
	/*
		*//**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
			 *      response)
			 *//*
				 * protected void doPost(HttpServletRequest request, HttpServletResponse
				 * response) throws ServletException, IOException { // TODO Auto-generated
				 * method stub doGet(request, response); }
				 */

}
