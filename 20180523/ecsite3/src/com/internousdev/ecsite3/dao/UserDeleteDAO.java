package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite3.util.DBConnector;

public class UserDeleteDAO
{
	String sql = "delete from login_user_transaction where user_name = ?";

	public void deleteUser(String userName) throws SQLException
	{
		DBConnector dbConnector= new DBConnector();
		Connection connection = dbConnector.getConnection();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, userName);


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