/**
 * @author Debasish Sahoo
 * @description This is an interface having different methods to be implemented in the implementation class.
 *
 */

package com.infinite.EmpApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.infinite.EmpApp.bean.Employee;

public interface EmployeeDao {
	public String addEmployee(Employee employee) throws ClassNotFoundException, SQLException;

	public String removeEmployee(String id) throws ClassNotFoundException, SQLException;

	public Employee getEmployeeById(String id) throws SQLException;

	public List<Employee> getEmployees() throws SQLException, ClassNotFoundException;

	public String updateEmployee(String id, Employee employee) throws ClassNotFoundException, SQLException;

}
