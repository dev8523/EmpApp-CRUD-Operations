/**
 * @author Debasish Sahoo
 * @description This class has the implementations of the Employee service interface for Registration and performing CRUD operations.
 *
 */

package com.infinite.EmpApp.service;

import java.sql.SQLException;
import java.util.List;

import com.infinite.EmpApp.bean.Employee;
import com.infinite.EmpApp.bean.LoginBean;
import com.infinite.EmpApp.dao.EmployeeDao;
import com.infinite.EmpApp.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeService empService = null;

	private EmployeeServiceImpl() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public static EmployeeService getInstance() {
		if (empService == null) {
			empService = new EmployeeServiceImpl();
			return empService;
		} else {
			return empService;
		}
	}

	EmployeeDao empDao = EmployeeDaoImpl.getInstance();

	@Override
	public String addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return empDao.addEmployee(employee);
	}

	@Override
	public String removeEmployee(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return empDao.removeEmployee(id);
	}

	@Override
	public Employee getEmployeeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return empDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployees() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return empDao.getEmployees();
	}

	@Override
	public String updateEmployee(String id, Employee employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(id, employee);
	}

}
