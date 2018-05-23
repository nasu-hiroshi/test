package com.internousdev.ecsite3.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite3.dao.CartItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware
{
	private String itemName;
	private String itemPrice;
	private String itemCount;
	public Map<String, Object> session;

	public void insertCart() throws SQLException
	{
		CartItemCompleteDAO setCart = new CartItemCompleteDAO();
		setCart.setCartItem(session.get("itemName").toString(), session.get("itemPrice").toString(), session.get("itemCount").toString());

	}
	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	public String getItemPrice()
	{
		return itemPrice;
	}
	public void setItemPrice(String itemPrice)
	{
		this.itemPrice = itemPrice;
	}
	public String getItemCount()
	{
		return itemCount;
	}
	public void setItemCount(String itemCount)
	{
		this.itemCount = itemCount;
	}
	public Map<String, Object> getSession()
	{
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
