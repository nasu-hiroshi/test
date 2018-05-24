package com.internousdev.ecsite3.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite3.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite3.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;

	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException
	{
		buyItemDTOList = (ArrayList<BuyItemDTO>) session.get("list");

		for(int i = 0; i < buyItemDTOList.size(); i++)
		{
			int a = buyItemDTOList.get(i).getItemStock();

			int id = buyItemDTOList.get(i).getId();

			int b = buyItemDTOList.get(i).getTotalPrice();
			String totalPrice = String.valueOf(b);

			int count = buyItemDTOList.get(i).getCount();

			int itemStock = a - count;
			System.out.println(itemStock);

			BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
			buyItemCompleteDAO.buyItemInfo(id, totalPrice, count, session.get("login_user_id").toString(), buyItemDTOList.get(i).getPay());
		}
		String result = SUCCESS;
		return result;
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
