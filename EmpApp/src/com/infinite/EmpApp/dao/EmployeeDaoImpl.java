/**
 * @author Debasish Sahoo
 * @description This class has the implementations of the Employee Dao interface for Registration and performing CRUD operations.
 *
 */

package com.infinite.EmpApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infinite.EmpApp.bean.Employee;
import com.infinite.EmpApp.utils.DBUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDao empDao; // SINGLETON

	private EmployeeDaoImpl() { // Singleton
		// super();
		// TODO Auto-generated constructor stub
	}

	public static EmployeeDao getInstance() // for SINGLETON design pattern
	{
		if (empDao == null) {
			empDao = new EmployeeDaoImpl();
			return empDao;
		} else {
			return empDao;
		}
	}

	@Override
	public String addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String insertEmp = "insert into registration(empId, password, firstname, lastname, empsal, doj, dob, gender, uploadresume, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(insertEmp);
			preparedStatement.setString(1, DBUtils.generateEmpId(employee.getEmpFN()));
			preparedStatement.setString(2, employee.getEmpPassword());
			preparedStatement.setString(3, employee.getEmpFN());
			preparedStatement.setString(4, employee.getEmpLN());
			preparedStatement.setFloat(5, employee.getEmpSal());
			preparedStatement.setString(6, employee.getDoj());
			preparedStatement.setString(7, employee.getDob());
			preparedStatement.setString(8, employee.getGender());
			preparedStatement.setString(9, employee.getUploadResume());
			preparedStatement.setString(10, employee.getEmpEmail());

			connection.setAutoCommit(false);// it is by default true.. when it is false, we have to gonna handle the
											// transaction. We have to set autoCommit false, and commit it.

			int res = preparedStatement.executeUpdate();
			connection.commit(); //
			return "successfully added";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();// If anything goes wrong, then we can rollback and restore the data.
			return "addition failed";
		} finally {
			preparedStatement.close();
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public String removeEmployee(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String removeEmp = "delete from registration where empid = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(removeEmp);
			preparedStatement.setString(1, id);
			connection.setAutoCommit(false);
			int res = preparedStatement.executeUpdate();
			connection.commit();// we have to do commit.
			return "removed successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();
			return "removed failed";
		} finally {
			preparedStatement.close();
			DBUtils.closeConnection(connection);
		}

	}

	@Override
	public String updateEmployee(String id, Employee employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String updateEmp = "update registration set password = ?, firstname = ?, lastname = ?, empsal = ?, doj = ?, dob = ?, gender = ?, uploadresume = ?, email = ? where empid = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(updateEmp);
			preparedStatement.setString(1, employee.getEmpPassword());
			preparedStatement.setString(2, employee.getEmpFN());
			preparedStatement.setString(3, employee.getEmpLN());
			preparedStatement.setFloat(4, employee.getEmpSal());
			preparedStatement.setString(5, employee.getDoj());
			preparedStatement.setString(6, employee.getDob());
			preparedStatement.setString(7, employee.getGender());
			preparedStatement.setString(8, employee.getUploadResume());
			preparedStatement.setString(9, employee.getEmpEmail());
			preparedStatement.setString(10, id);
			connection.setAutoCommit(false);
			int res = preparedStatement.executeUpdate();
			connection.commit();
			return "updates successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();
			return "updation failed";
		} finally {
			preparedStatement.close();
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public Employee getEmployeeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from registration where empid = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		Employee employee = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String eId = resultSet.getString("empId");
				String ePd = resultSet.getString("password");
				String eFN = resultSet.getString("firstname");
				String eLN = resultSet.getString("lastname");
				Float eSal = resultSet.getFloat("empSal");
				String edoj = resultSet.getString("doj");
				String edob = resultSet.getString("dob");
				String egen = resultSet.getString("gender");
				String eUpRes = resultSet.getString("uploadResume");
				String eEMail = resultSet.getString("email");

				Employee employee1 = new Employee(eId, ePd, eFN, eLN, eSal, edoj, edob, egen, eUpRes, eEMail);
				return employee1;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return null;
		} finally {
			preparedStatement.close();
			resultSet.close();
			connection.close();
		}

		return null;

	}

	@Override
	public List<Employee> getEmployees() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Employee> list = new ArrayList<>();
		String query = "select * from registration";
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String eId = resultSet.getString("userid");
				String ePd = resultSet.getString("password");
				String eFN = resultSet.getString("firstname");
				String eLN = resultSet.getString("lastname");
				Float eSal = resultSet.getFloat("empSal");
				String edoj = resultSet.getString("doj");
				String edob = resultSet.getString("dob");
				String egen = resultSet.getString("gender");
				String eUpRes = resultSet.getString("uploadresume");
				String eEmail = resultSet.getString("email");

				Employee employee = new Employee(eId, ePd, eFN, eLN, eSal, edoj, edob, egen, eUpRes, eEmail);
				list.add(employee);

			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return null;
		} finally {
			preparedStatement.close();
			resultSet.close();
			connection.close();
		}

	}

}
