/**
 * @author Debasish Sahoo
 * @description This class is for providing Database connection
 *
 */

package com.infinite.EmpApp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	// DBUTILS class should contain all static methods.

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // Type-4 driver name
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
		return connection;
	}

	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}

	public static String generateEmpId(String firstName) throws ClassNotFoundException, SQLException {
		// will help us to generate customized emp id
		// 10001 abhi -> ab10001

		String sqlStatement = "select emp_seq.nextval as empid from dual";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sqlStatement);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return firstName.substring(0, 2) + resultSet.getString("empid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection(connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

}
