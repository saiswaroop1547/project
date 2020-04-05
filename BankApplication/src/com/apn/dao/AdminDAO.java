package com.apn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.apn.bo.UserBO;
import com.apn.databasecon.JdbcConnection;

public class AdminDAO implements IAdminDAO {

	@Override
	/*To check if a user is registered with the same email and mobile*/
	public boolean validateData(UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		//boolean flag=true;
		/*gives list of all users in userdetails table*/
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		
		String sql = "select * from userdetails where email=? and mobile=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getMobile());
		ResultSet resultSet = preparedStatement.executeQuery();
		boolean test=resultSet.next();
		/*while(resultSet.next())
		{
			
			flag=false;
		}*/
		System.out.println("test is:"+test);
		return test;
	}

	/*This method returns all users in userdetails table*/
	@Override
	public List<UserBO> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		String sql = "select * from userdetails";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List <UserBO> allUsers = new ArrayList<UserBO>();
		while(resultSet.next())
		{
			UserBO user = new UserBO();
			user.setFirstName(resultSet.getString(2));
			user.setLastName(resultSet.getString(3));
			user.setGender(resultSet.getString(4));
			user.setAddress(resultSet.getString(5));
			user.setMobile(resultSet.getString(6));
			user.setEmail(resultSet.getString(7));
			user.setAccountNo(resultSet.getString(8));
			user.setUserId(resultSet.getString(9));
			user.setPassowrd(resultSet.getString(10));
			user.setBalance(resultSet.getFloat(11));
			user.setStatus(resultSet.getString(12));

			allUsers.add(user);
		}
		return allUsers;
	}
	
	/* This method generates an account number (format-APN+last two digits of the date+number) based on the previous account number*/
	@Override
	public String generateAccountNo() throws SQLException
	{
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy");
		 /*To get the last registered account number*/
		String sql = "select accountno from userdetails where id = (select max(id) from userdetails)";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String accountNo = null;
		while(resultSet.next())
		{
			String 	previousAccountNo = resultSet.getString("accountNo");
			previousAccountNo = previousAccountNo.substring(5,10);
			
			int no = Integer.parseInt(previousAccountNo)+1;
			accountNo = "APN"+dtf.format(LocalDateTime.now())+String.format("%05d",no);
		}	
		return accountNo;
		
	}

	/*This method checks if there is a user with the userId and password entered*/
	@Override
	public boolean validateCredentials(String userId,String password) throws SQLException
	{
		boolean flag=false;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		System.out.println("connected");
		/*Query to check if the user id and password combination exists and the status is active*/
		String sql="select * from userdetails where userid=? and password=? and status='active'";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		System.out.println("queryexecuted");
		preparedStatement.setString(1, userId);
		preparedStatement.setString(2, password);
		System.out.println("uid "+userId+" pwd "+password);
		ResultSet resultSet=preparedStatement.executeQuery();
		boolean test = resultSet.next();
		/*while(!(resultSet.next()))
		{
			flag= true;
		}*/
		System.out.println("after while");
		System.out.println("test is "+test);
		return test;
		//return flag;
	}

	/*This method returns the user details  as user object of the user with the entered AccountNo*/
	@Override
	public UserBO searchUserByAccountNo(String accountNo) throws SQLException {
		// TODO Auto-generated method stub
		UserBO user=null;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		String sql="select * from userdetails where accountNo=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, accountNo);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			user=new UserBO();
			user.setFirstName(resultSet.getString(1));
			user.setLastName(resultSet.getString(2));
			user.setGender(resultSet.getString(3));
			user.setAddress(resultSet.getString(4));
			user.setMobile(resultSet.getString(5));
			user.setEmail(resultSet.getString(6));
			user.setAccountNo(resultSet.getString(7));
			user.setUserId(resultSet.getString(8));
			user.setPassowrd(resultSet.getString(9));
			user.setBalance(resultSet.getFloat(10));
			user.setStatus(resultSet.getString(11));
		}
		return user;
	}

	/*This method returns user details as user object of the user with the entered userId
	 * If user doesn't exist it returns null*/
	@Override
	public UserBO searchUserByUserId(String userId) throws SQLException {
		System.out.println("inside searchuser by id");
		// TODO Auto-generated method stub
		UserBO user=null;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		/*Query to return user details with the user id*/
		String sql="select * from userdetails where userId=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, userId);
		ResultSet resultSet=preparedStatement.executeQuery();
		System.out.println("afterqueryexecution");
		
		while(resultSet.next())
		{
			user=new UserBO();
			user.setFirstName(resultSet.getString(1));
			user.setLastName(resultSet.getString(2));
			user.setGender(resultSet.getString(3));
			user.setAddress(resultSet.getString(4));
			user.setMobile(resultSet.getString(5));
			user.setEmail(resultSet.getString(6));
			user.setAccountNo(resultSet.getString(7));
			user.setUserId(resultSet.getString(8));
			user.setPassowrd(resultSet.getString(9));
			user.setBalance(resultSet.getFloat(10));
			user.setStatus(resultSet.getString(11));
		}
		return user;
	}

}
