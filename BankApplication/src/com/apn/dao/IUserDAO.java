package com.apn.dao;

import java.sql.SQLException;

import com.apn.bo.UserBO;

public interface IUserDAO {
	/*This method inserts user details from register page to userdetails table;*/
	public UserBO createAccount(UserBO user) throws SQLException;
	
	/*this method sets the status of the user to inactive*/
	public boolean closeAccount(UserBO user) throws SQLException;

	/*This method updates the balance of the user*/
	public boolean deposit(float amount,UserBO user) throws SQLException;

	/*This method updates the balance of the user*/
	public boolean withdraw(float amount,UserBO user) throws SQLException;

	/*This method updates the balance of the user and target*/
	public boolean transfer(UserBO user,UserBO target,float amount)throws SQLException;
	
	/*This method returns the balance user*/
	public float checkBalance(String accountNo) throws SQLException;
}

