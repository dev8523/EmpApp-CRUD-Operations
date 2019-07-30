package com.infinite.EmpApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinite.EmpApp.bean.Employee;
import com.infinite.EmpApp.service.EmployeeService;
import com.infinite.EmpApp.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpRegistartionServlet
 */
public class EmpRegistartionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EmpRegistartionServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doGet(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 * }
		 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String empId = request.getParameter("empid");
		String empPass = request.getParameter("password");
		String empFN = request.getParameter("firstname");
		String empLN = request.getParameter("lastname");
		Float empSal = Float.parseFloat(request.getParameter("salary"));
		String empDoj = request.getParameter("doj");
		String empDob = request.getParameter("dob");
		String empGen = request.getParameter("gender");
		String empResume = request.getParameter("resume");
		String empEmail = request.getParameter("email");

		Employee employee = new Employee(empId, empPass, empFN, empLN, empSal, empDoj, empDob, empGen, empResume,
				empEmail);
		EmployeeService employeeService = EmployeeServiceImpl.getInstance();

		System.out.println(employee.getEmpId());
		System.out.println(employee.getEmpPassword());
		System.out.println(employee.getEmpFN());
		System.out.println(employee.getEmpLN());
		System.out.println(employee.getEmpSal());
		System.out.println(employee.getDoj());
		System.out.println(employee.getDob());
		System.out.println(employee.getGender());
		System.out.println(employee.getUploadResume());
		System.out.println(employee.getEmpEmail());

		String res = null;
		try {
			res = employeeService.addEmployee(employee);
			if (res.isEmpty()) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
				requestDispatcher.forward(request, response); // Don't forget to add forward method for redirecting
																// pages when using
																// RequestDispatcher
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("registrationConfirmation.html");
				requestDispatcher.forward(request, response); // Don't forget to add forward method for redirecting
																// pages when using
																// RequestDispatcher
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
