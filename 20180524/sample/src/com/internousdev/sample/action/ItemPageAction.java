package com.internousdev.sample.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sample.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemPageAction extends ActionSupport implements SessionAware
{
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemStock;
	private Map<String, Object> session;

	public String execute() throws SQLException
	{
		@SuppressWarnings("unchecked")
		List<BuyItemDTO> itemList =  (List<BuyItemDTO>) session.get("itemList");

		String result = SUCCESS;
		return result;
	}
	public int getItemId()
	{
		return itemId;
	}
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	public int getItemParice()
	{
		return itemPrice;
	}
	public void setItemPrice(int itemPrice)
	{
		this.itemPrice = itemPrice;
	}
	public int getItemStock()
	{
		return itemStock;
	}
	public void setItemStock(int itemStock)
	{
		this.itemStock = itemStock;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;

	}
}