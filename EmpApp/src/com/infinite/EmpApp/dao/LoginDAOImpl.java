package com.infinite.EmpApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infinite.EmpApp.bean.Employee;
import com.infinite.EmpApp.bean.LoginBean;
import com.infinite.EmpApp.utils.DBUtils;

public class LoginDAOImpl implements LoginDAO {

	private static LoginDAOImpl loginDaoImpl = null;// SINGLETON

	public static LoginDAOImpl getInstance() // for SINGLETON design pattern
	{
		if (loginDaoImpl == null) {
			loginDaoImpl = new LoginDAOImpl();
			return loginDaoImpl;
		} else {
			return loginDaoImpl;
		}
	}

	private LoginDAOImpl() { // SINGLETON
		// super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public String addLoginDetails(LoginBean bean) throws SQLException {
		// TODO Auto-generated method stub
		String insertEmp = "insert into login(userid, password) values (?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(insertEmp);

			preparedStatement.setString(1, bean.getUserId());
			preparedStatement.setString(2, bean.getPassword());

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
	public String deleteLogin(String id) throws SQLException {
		// TODO Auto-generated method stub
		String removeEmp = "delete from login where userid = ?";
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
	public String updateLoginDetails(LoginBean bean) throws SQLException {
		// TODO Auto-generated method stub
		String updateEmp = "update empl set userid = ?, password = ? where userid = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(updateEmp);
			preparedStatement.setString(1, bean.getUserId());
			preparedStatement.setString(2, bean.getPassword());

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
	public boolean authentication(LoginBean bean) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from login where userid = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		Employee employee = null;

		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bean.getUserId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString(1).equals(bean.getUserId())
						&& resultSet.getString(2).equals(bean.getPassword())) {
					return true;
				}
			}
			connection.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();
			return false;
		} finally {
			preparedStatement.close();
			resultSet.close();
			connection.close();
		}
		return false;
	}

	@Override
	public String changeStatus(String id, int status) throws SQLException {
		// TODO Auto-generated method stub
		String updateStatement = "update login set userstatus = ? where userid = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setInt(1, status);
			preparedStatement.setString(2, id);
			int res = preparedStatement.executeUpdate();
			connection.commit();
			return "updates successfully";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();
			return "updation failed";
		} finally {
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public int checkStatus(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select userstatus from login where userid = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet res = null;
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);

			res = preparedStatement.executeQuery();
			if (res.next()) {
				return res.getInt(1); // tells if it is logged in
			}

			connection.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();
			return -1;
		} finally {
			DBUtils.closeConnection(connection);
		}
		return -1;

	}

	@Override
	public String authorisation(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select usertype from login where userid = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet res = null;
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);

			res = preparedStatement.executeQuery();
			if (res.next()) {
				return res.getString(1); // tells if it is logged in
			}
			connection.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connection.rollback();
			return "authorisation fail";
		} finally {
			DBUtils.closeConnection(connection);
		}
		return "error occured";
	}

}
