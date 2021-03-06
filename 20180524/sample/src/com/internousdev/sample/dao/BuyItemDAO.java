package com.internousdev.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sample.dto.BuyItemDTO;
import com.internousdev.sample.util.DBConnector;

public class BuyItemDAO
{
	private DBConnector dbConnector= new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public List<BuyItemDTO> getBuyItemInfo()
	{
		String sql = "SELECT id, item_name, item_price , item_stock FROM item_info_transaction";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				BuyItemDTO dto = new BuyItemDTO();
				dto.setItemId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getInt("item_Stock"));
				buyItemDTOList.add(dto);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return buyItemDTOList;
	}
	public List<BuyItemDTO> getBuyItemDTOList()
	{
		return buyItemDTOList;
	}
}