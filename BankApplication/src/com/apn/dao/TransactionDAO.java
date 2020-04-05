package com.apn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apn.bo.TransactionBO;
import com.apn.databasecon.JdbcConnection;

public class TransactionDAO implements ITransactionDAO{

	@Override
	public void addTransaction(TransactionBO transaction) throws SQLException {
		// TODO Auto-generated method stub
		int count=0;
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection connection = jdbcConnection.getJdbcConnection();
		System.out.println("after transaction table connection");
		String sql = "insert into transaction values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("after query execution");
		
		
		
		
		preparedStatement.setString(1,transaction.getAccountNo());
		preparedStatement.setString(2, transaction.getTransactionType());
		preparedStatement.setString(3, transaction.getTransactionDescription());
		
		
		count=preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("after query updated successfully...");
		}
		jdbcConnection.closeJdbcConnection();
		System.out.println("after connection closed");
	}

}
