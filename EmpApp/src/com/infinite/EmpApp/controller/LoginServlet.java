package com.infinite.EmpApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinite.EmpApp.bean.LoginBean;
import com.infinite.EmpApp.service.EmployeeService;
import com.infinite.EmpApp.service.EmployeeServiceImpl;
import com.infinite.EmpApp.service.LoginService;
import com.infinite.EmpApp.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		LoginService loginService = LoginServiceImpl.getInstance();
		String userName = request.getParameter("username"); // here userName is given in html/JSP page
		String password = request.getParameter("password");
		LoginBean bean = new LoginBean(userName, password);
		HttpSession httpSession = null;
		try {
			if (loginService.authentication(bean)) {
				int userStatus = loginService.checkStatus(userName);
				if (userStatus == 0) {
					httpSession = request.getSession();
					System.out.println(httpSession.isNew());
					httpSession.setAttribute("username", userName);// first argument is string in which 2nd value will
																	// be stored
					String userType = loginService.authorisation(userName);
					if ("a".equals(userType)) {
						loginService.changeStatus(userName, 1);
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp"); // in this
																									// RequestDispatcher
																									// change will be in
																									// URL
						dispatcher.forward(request, response);
					} else if ("u".equals(userType)) {
						loginService.changeStatus(userName, 1);
						RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp"); // in this
																									// RequestDispatcher
																									// change will be in
																									// URL
						dispatcher.forward(request, response);
					}
				} else if (userStatus == 1) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("alreadyLogin.jsp"); // in this
																										// RequestDispatcher
																										// change will
																										// be in URL
					dispatcher.forward(request, response);
				} else if (userStatus == 2) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("deactivatedUser.jsp"); // in this
																										// RequestDispatcher
																										// change will
																										// be in URL
					dispatcher.forward(request, response);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//--------------------------------------------------------------------------------------------------------------------------------------------------------		
		/*
		 * //System.out.println("hello from deba..."); //it will show on server side.
		 * //No. of times we will refresh the page n no. of times service method //will
		 * be called and the doPost() method will be executed and hello from deba...
		 * //will be printed in server
		 * 
		 * //Retrieving username and password from login.html String userName =
		 * request.getParameter("username"); //here userName is given in html page
		 * String password = request.getParameter("password");
		 * 
		 * if("admin".equals(userName) && "admin".equals(password)) { //redirect to
		 * admin.html //response.sendRedirect("admin.html"); //It will redirect to the
		 * admin.html page
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("admin.html");
		 * //in this RequestDispatcher change will be in URL dispatcher.forward(request,
		 * response);
		 * 
		 * response.setHeader("location", "admin.html"); response.setStatus(302); //for
		 * shifting temporary locaton } else if("user".equals(userName) &&
		 * "user".equals(password)) { //redirect to user.html
		 * response.sendRedirect("user.html"); //It will redirect to the user.html page
		 * } else { //redirect to home page. response.sendRedirect("login.html"); //It
		 * will redirect to the login.html page }
		 */
//------------------------------------------------------------------------------------------------------------------------------------
		// check authenticaton from login.html

		/*
		 * EmployeeService employeeService = EmployeeServiceImpl.getInstance();
		 * System.out.println("hello from shree"); String userName =
		 * request.getParameter("username"); //here userName is given in html page
		 * String password = request.getParameter("password"); LoginBean loginBean = new
		 * LoginBean(userName, password); LoginService loginService =
		 * LoginServiceImpl.getInstance(); RequestDispatcher dispatcher = null; try {
		 * if(loginService.authentication(loginBean)) { dispatcher =
		 * request.getRequestDispatcher("admin.html"); //in this RequestDispatcher
		 * change will be in URL dispatcher.forward(request, response); } else
		 * if("user".equals(userName) && "user".equals(password)) { //redirect to
		 * user.html response.sendRedirect("user.html"); //It will redirect to the
		 * user.html page } else { //redirect to home page.
		 * response.sendRedirect("login.html"); //It will redirect to the login.html
		 * page } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
//------------------------------------------------------------------------------------------------------------------------------------		

		/*
		 * LoginService loginService = LoginServiceImpl.getInstance();
		 * System.out.println("hello from shree"); String userName =
		 * request.getParameter("username"); //here userName is given in html page
		 * String password = request.getParameter("password"); LoginBean loginBean = new
		 * LoginBean(userName, password);
		 * 
		 * RequestDispatcher dispatcher = null; try {
		 * if(loginService.authentication(loginBean)) { dispatcher =
		 * request.getRequestDispatcher("admin.html"); //in this RequestDispatcher
		 * change will be in URL dispatcher.forward(request, response); } else
		 * if("user".equals(userName) && "user".equals(password)) { //redirect to
		 * user.html response.sendRedirect("user.html"); //It will redirect to the
		 * user.html page } else { //redirect to home page.
		 * response.sendRedirect("login.html"); //It will redirect to the login.html
		 * page } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

}
