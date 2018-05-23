package com.internousdev.ecsite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite3.dto.MyPageDTO;
import com.internousdev.ecsite3.util.DBConnector;

public class MyPageDAO
{
	private DBConnector dbConnector= new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String user_master_id) throws SQLException
	{
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id where ubit.user_master_id  = ? ORDER BY insert_date DESC";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				MyPageDTO dto = new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setinsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			connection.close();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String user_master_id) throws SQLException
	{

		String sql = "DELETE FROM user_buy_item_transaction where user_master_id  = ?";
		PreparedStatement preparedStatement;
		int result = 0;

		try
		{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);

			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			connection.close();
		}
		return result;
	}
}
