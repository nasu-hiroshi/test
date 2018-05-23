package com.internousdev.ecsite3.dto;

public class BuyItemDTO
{
	private int id;
	private String itemName;
	private String itemPrice;
	private int count;
	private int totalPrice;
	private String pay;
	private int itemStock;
	private int totalCount;

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
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getItemStock()
	{
		return itemStock;
	}
	public void setItemStock(int itemStock)
	{
		this.itemStock = itemStock;
	}
	public int getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public String getPay()
	{
		return pay;
	}
	public void setPay(String pay)
	{
		this.pay = pay;
	}
}