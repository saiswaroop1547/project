package com.apn.dao;

import java.sql.SQLException;

import com.apn.bo.TransactionBO;

public interface ITransactionDAO {
	public void addTransaction(TransactionBO transaction) throws SQLException;

}
