package com.apn.dao;

import java.sql.SQLException;
import java.util.List;

import com.apn.bo.UserBO;

public interface IAdminDAO {
	public  boolean validateData(UserBO user) throws SQLException;
	public List<UserBO> getAllUser() throws SQLException;
	public String generateAccountNo() throws SQLException;
	public boolean validateCredentials(String userName,String password) throws SQLException;
	public UserBO searchUserByAccountNo(String accountNo) throws SQLException;
	public UserBO searchUserByUserId(String userId) throws SQLException;
	
}
