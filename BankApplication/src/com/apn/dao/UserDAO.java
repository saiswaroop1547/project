package com.apn.dao;

import java.sql.*;

import com.apn.bo.TransactionBO;
import com.apn.bo.UserBO;
import com.apn.databasecon.JdbcConnection;


public class UserDAO implements IUserDAO {
	
	/*This method inserts user details from register page to userdetails table;*/
	@Override
	public UserBO createAccount(UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = new AdminDAO();
		UserBO userBO = null;
		/*Creating OracleConnection object*/
		JdbcConnection jdbcConnection = new JdbcConnection();
		/*Calling getConnection method from OracleConnection class*/
		Connection connection = jdbcConnection.getJdbcConnection();
		System.out.println("sfter connection and before if");
		if(adminDAO.validateData(user)==false)
		{	
			System.out.println("in the first if");
			userBO = user;
			/*inserting the registered user details into the userdetails table*/
			String sql = "insert into userdetails values(?,?,?,?,?,?,?,?,?,?,?)";
			/*Setting the auto-generated account no*/
			//userBO.setAccountNo(adminDAO.generateAccountNo());
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userBO.getFirstName());
			preparedStatement.setString(2, userBO.getLastName());
			preparedStatement.setString(3, userBO.getGender());
			preparedStatement.setString(4, userBO.getAddress());
			preparedStatement.setString(5, userBO.getMobile());
			preparedStatement.setString(6, userBO.getEmail());
			preparedStatement.setString(7, userBO.getAccountNo());
			preparedStatement.setString(8, userBO.getUserId());
			preparedStatement.setString(9, userBO.getPassowrd());
			preparedStatement.setFloat(10, userBO.getBalance());
			preparedStatement.setString(11, userBO.getStatus());
			if(preparedStatement.executeUpdate()>0)
			{
				System.out.println("in the second if");
				String transactionDescription="Account created";
				TransactionBO transaction=new TransactionBO(user.getAccountNo(),"New Account",transactionDescription);
				TransactionDAO transactionDAO=new TransactionDAO();
				transactionDAO.addTransaction(transaction);
			}
		}
		/*Closing the database connection*/
		jdbcConnection.closeJdbcConnection();
		return userBO;
	}

	/*This method updates the balance of the user*/
	@Override
	public boolean deposit(float amount,UserBO user) throws SQLException
	{
		boolean flag=false;
		/*Creating OracleConnection object*/
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		/*Query to set the balance of the user*/
		String sql = "update userdetails set balance=? where accountno=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		UserDAO userDAO = new UserDAO();
		amount += userDAO.checkBalance(user.getAccountNo());
		preparedStatement.setFloat(1, amount);
		preparedStatement.setString(2, user.getAccountNo());
		if(preparedStatement.executeUpdate()>0)
		{
			/*If the query is executed, the transaction is entered into transactiondetails*/
			String transactionDescription="Deposited "+amount;
			TransactionBO transaction=new TransactionBO(user.getAccountNo(),"Deposit",transactionDescription);
			TransactionDAO transactionDAO=new TransactionDAO();
			transactionDAO.addTransaction(transaction);
			flag= true;
		}
		/*close database connection*/
		jdbcConnection.closeJdbcConnection();
		return flag;
	}

	/*This method updates the balance of the user*/
	@Override
	public boolean withdraw(float amount, UserBO user) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		UserDAO userDAO = new UserDAO();
		amount = userDAO.checkBalance(user.getAccountNo())-amount;
		/*To check if there is sufficient balance*/
		if(amount>=0)
		{
			/*Query to set the balance of the user*/
			String sql = "update userdetails set balance=? where accountno=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, amount);
			preparedStatement.setString(2, user.getAccountNo());
			if(preparedStatement.executeUpdate()>0)
			{
				/*If the query is executed, the transaction is entered into transactiondetails*/
				String transactionDescription="Withdrawn "+amount;
				TransactionBO transaction=new TransactionBO(user.getAccountNo(),"Withdraw",transactionDescription);
				TransactionDAO transactionDAO=new TransactionDAO();
				transactionDAO.addTransaction(transaction);
				flag= true;
			}
		}
		jdbcConnection.closeJdbcConnection();
		return flag;
	}

	/*This method updates the balance of the user and target*/
	@Override
	public boolean transfer(UserBO user,UserBO target,float amount) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		System.out.println("after connection to db");
		UserDAO userDAO = new UserDAO();
		float ubalance = userDAO.checkBalance(user.getAccountNo())-amount;
		/*To check if there is sufficient balance*/
		System.out.println("balance after transfer is:"+ubalance);
		if(ubalance>=0)
		{
			System.out.println("insidde ubalance >=0");
			/*Query to set the balance of the user*/
			String sql = "update userdetails set balance=? where accountno=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, ubalance);
			preparedStatement.setString(2, user.getAccountNo());
			if(preparedStatement.executeUpdate()>0)
			{
				System.out.println("after execute update of ps");
				/*Query to set the balance of the user*/
				sql = "update userdetails set balance=? where accountno=?";
				preparedStatement = connection.prepareStatement(sql);
				float tbalance = userDAO.checkBalance(target.getAccountNo())+amount;
				System.out.println("after target get credited"+tbalance);
				preparedStatement.setFloat(1, tbalance);
				preparedStatement.setString(2, target.getAccountNo());
				if(preparedStatement.executeUpdate()>0)
				{
					System.out.println("inside the transactions table");
					/*If the query is executed, the transaction is entered into transactiondetails*/
					String transactionDescription="Transfered "+amount+" to "+target.getAccountNo();
					TransactionBO transaction=new TransactionBO(user.getAccountNo(),"Transfer",transactionDescription);
					TransactionDAO transactionDAO=new TransactionDAO();
					transactionDAO.addTransaction(transaction);
					System.out.println("before flag is true");
					flag= true;
				}	
			}
		}
		/*close database connection*/
		jdbcConnection.closeJdbcConnection();
		System.out.println("flag is true:"+flag);
		return flag;
	}

	/*This method returns the balance user*/
	@Override
	public float checkBalance(String accountNo) throws SQLException {
		// TODO Auto-generated method stub
		float balance=0;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		System.out.println("after con in checkbalance ");
		/*Query to select balance of the user*/
		String sql = "select balance from userdetails where accountNo=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, accountNo);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			System.out.println("inside while in check balance");
			balance=resultSet.getFloat(1);
		/*close database connection*/
		System.out.println("balance is:"+balance);
		}
		jdbcConnection.closeJdbcConnection();
		return balance;
	}
	
	/*this method sets the status of the user to inactive*/
	@Override
	public boolean closeAccount(UserBO user) throws SQLException {
		 //TODO Auto-generated method stub
		boolean flag=false;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		/*Query to set the status as inactive*/
		String sql = "update userdetails set status='inactive' where accountno=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getAccountNo());
		if(preparedStatement.executeUpdate()>0)
		{
			String transactionDescription="Account closed";
			TransactionBO transaction=new TransactionBO(user.getAccountNo(),"Close Account",transactionDescription);
			TransactionDAO transactionDAO=new TransactionDAO();
			transactionDAO.addTransaction(transaction);
			flag= true;
		}
		/*close database connection*/
		jdbcConnection.closeJdbcConnection();
		return flag;
	}
}

