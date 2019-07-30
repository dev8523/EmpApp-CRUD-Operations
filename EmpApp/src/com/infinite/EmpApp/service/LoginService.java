package com.infinite.EmpApp.service;

import java.sql.SQLException;

import com.infinite.EmpApp.bean.LoginBean;

public interface LoginService {

	public String addLoginDetails(LoginBean bean) throws SQLException;

	public String deleteLogin(String id) throws SQLException;

	public String updateLoginDetails(LoginBean bean) throws SQLException;

	public boolean authentication(LoginBean bean) throws SQLException;

	public String changeStatus(String id, int status) throws SQLException;

	// public String changeStatus(String id, int status) throws SQLException;
	public int checkStatus(String id) throws SQLException;

	public String authorisation(String id) throws SQLException;
}
