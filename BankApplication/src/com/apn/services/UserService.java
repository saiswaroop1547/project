package com.apn.services;

import java.sql.SQLException;
import com.apn.dao.*;
import com.apn.bo.UserBO;

public class UserService implements IUserService  {

	@Override
	public UserBO createAccount(UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
	
		return userDAO.createAccount(user);
		
	}

	@Override
	public boolean closeAccount(UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		
		
		return userDAO.closeAccount(user);
	}

	@Override
	public boolean deposit(float amount, UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		
		return userDAO.deposit(amount, user);
		
	}

	@Override
	public boolean withdraw(float amount, UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		
		return userDAO.withdraw(amount, user);
		
	}

	@Override
	public boolean transfer(UserBO user, UserBO target, float amount) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		return userDAO.transfer(user, target, amount);
		
	}

	@Override
	public float checkBalance(String accountNo) throws SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		
		return userDAO.checkBalance(accountNo);
	}
	
}
