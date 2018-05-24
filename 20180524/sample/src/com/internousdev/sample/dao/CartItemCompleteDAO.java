package com.internousdev.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.sample.util.DBConnector;
import com.internousdev.sample.util.DateUtil;

public class CartItemCompleteDAO
{
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO user_cart_item_transaction (item_transaction_id, item_name, item_price, item_count, total_price, user_master_id, insert_date) VALUES(?, ?, ?, ?, ?, ?, ?)";

	public void setCartItem(int item_transaction_id, String itemName, int itemPrice, int itemCount, int totalPrice, String user_master_id) throws SQLException
	{
		DBConnector dbConnector= new DBConnector();
		Connection connection = dbConnector.getConnection();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_transaction_id);
			preparedStatement.setString(2, itemName);
			preparedStatement.setInt(3, itemPrice);
			preparedStatement.setInt(4, itemCount);
			preparedStatement.setInt(5, totalPrice);
			preparedStatement.setString(6, user_master_id);
			preparedStatement.setString(7, dateUtil.getDate());

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
