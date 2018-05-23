package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite3.util.DBConnector;
import com.internousdev.ecsite3.util.DateUtil;

public class BuyItemCompleteDAO
{
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?, ?, ?, ?, ?, ?)";

	public void buyItemInfo(int item_transaction_id, String totalPrice, int totalCount, String user_master_id, String pay) throws SQLException
	{
		DBConnector dbConnector= new DBConnector();
		Connection connection = dbConnector.getConnection();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_transaction_id);
			preparedStatement.setString(2, totalPrice);
			preparedStatement.setInt(3, totalCount);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());

			preparedStatement.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			connection.close();
		}
	}
}
