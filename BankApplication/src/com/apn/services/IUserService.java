package com.apn.services;

import java.sql.SQLException;

import com.apn.bo.UserBO;

public interface IUserService {
	public UserBO createAccount(UserBO user) throws SQLException;
	public boolean closeAccount(UserBO user) throws SQLException;
	public boolean deposit(float amount,UserBO user) throws SQLException;
	public boolean withdraw(float amount,UserBO user) throws SQLException;
	public boolean transfer(UserBO user,UserBO target,float amount)throws SQLException;
	public float checkBalance(String accountNo) throws SQLException;
}
