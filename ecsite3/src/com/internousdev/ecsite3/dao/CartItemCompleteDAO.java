package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite3.util.DBConnector;
import com.internousdev.ecsite3.util.DateUtil;

public class CartItemCompleteDAO
{
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO user_cart_item_transaction(item_name, item_price, item_count insert_date) VALUES(?, ?, ?, ?)";

	public void setCartItem(String itemName, String itemPrice, String itemCount) throws SQLException
	{
		DBConnector dbConnector= new DBConnector();
		Connection connection = dbConnector.getConnection();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemPrice);
			preparedStatement.setString(3, itemCount);
			preparedStatement.setString(4, dateUtil.getDate());

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
