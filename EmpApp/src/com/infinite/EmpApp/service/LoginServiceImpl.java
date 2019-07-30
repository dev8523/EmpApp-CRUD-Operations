package com.infinite.EmpApp.service;

import java.sql.SQLException;

import com.infinite.EmpApp.bean.LoginBean;
import com.infinite.EmpApp.dao.LoginDAO;
import com.infinite.EmpApp.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	private static LoginServiceImpl loginServiceImpl = null;// SINGLETON

	private LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static LoginServiceImpl getInstance() // for SINGLETON design pattern
	{
		if (loginServiceImpl == null) {
			loginServiceImpl = new LoginServiceImpl();
			return loginServiceImpl;
		} else {
			return loginServiceImpl;
		}
	}

	LoginDAO loginDao = LoginDAOImpl.getInstance();

	@Override
	public String addLoginDetails(LoginBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.addLoginDetails(bean);
	}

	@Override
	public String deleteLogin(String id) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.deleteLogin(id);
	}

	@Override
	public String updateLoginDetails(LoginBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.updateLoginDetails(bean);
	}

	@Override
	public boolean authentication(LoginBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.authentication(bean);
	}

	@Override
	public String changeStatus(String id, int status) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.changeStatus(id, status);
	}

	@Override
	public int checkStatus(String id) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.checkStatus(id);
	}

	@Override
	public String authorisation(String id) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.authorisation(id);
	}

}
