package com.internousdev.sample.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sample.dao.CartItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware
{
	private String itemName;
	private int itemPrice;
	private int itemCount;
	private Map<String, Object> session;

	public String execute() throws SQLException
	{
		int itemId;
		int totalPrice;
		String userId;

		itemId = Integer.parseInt((String) session.get("id"));
		userId = (String) session.get("login_user_id");
		totalPrice = (itemPrice * itemCount);

		CartItemCompleteDAO cartItemInsert = new CartItemCompleteDAO();
		cartItemInsert.setCartItem(itemId, itemName, itemPrice, itemCount, totalPrice, userId);

		String result = SUCCESS;
		return result;
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
	public int getItemCount()
	{
		return itemCount;
	}
	public void setItemCount(int itemCount)
	{
		this.itemCount = itemCount;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;

	}
}