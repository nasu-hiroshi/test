package com.internousdev.ecsite3.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite3.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware
{
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<>();
	List<String> count;
	private String pay;
	public Map<String, Object> session;

	public String execute()
	{

		String result = SUCCESS;

		session.put("count", count);

		@SuppressWarnings("unchecked")
		List<BuyItemDTO> list =  (List<BuyItemDTO>) session.get("buyItemDTOList");



		for(int i = 0; i < count.size(); i++)
		{
			BuyItemDTO buyItemDTO = new BuyItemDTO();

			String buyItemName = list.get(i).getItemName();
			session.put("itemName", buyItemName);

			String buyItemPrice = list.get(i).getItemPrice();
			session.put("itemPrice", buyItemPrice);

			int buyItemId = list.get(i).getId();
			session.put("id", buyItemId);

			int itemStock = list.get(i).getItemStock();


			int intCount = Integer.parseInt(count.get(i));
			int intPrice = Integer.parseInt(list.get(i).getItemPrice());

			if(intCount != 0)
			{
				buyItemDTO.setId((int) session.get("id"));
				buyItemDTO.setItemName(session.get("itemName").toString());
				buyItemDTO.setItemPrice(session.get("itemPrice").toString());
				buyItemDTO.setCount(intCount);
				buyItemDTO.setItemStock(itemStock);
				buyItemDTO.setTotalPrice(intCount * intPrice);
				session.put("totalPrice", intCount * intPrice);

				String payment;

				if(pay.equals("1"))
				{
					payment = "現金払い";
					session.put("pay", payment);
					buyItemDTO.setPay(payment);
				}
				else
				{
					payment = "クレジットカード";
					session.put("pay", payment);
					buyItemDTO.setPay(payment);
				}
				buyItemDTOList.add(buyItemDTO);
			}
			session.put("list", buyItemDTOList);
		}
		if(buyItemDTOList.size() > 1)
		{
			int totalPrice = 0;
			for(int a = 0; a < buyItemDTOList.size(); a++)
			{
				totalPrice = totalPrice + buyItemDTOList.get(a).getTotalPrice();
			}
			System.out.println(totalPrice);
			session.put("totalPrice", totalPrice);
		}
		return result;
	}

	public List<String> getCount()
	{
		return count;
	}
	public void setCount(List<String> count)
	{
		this.count = count;
	}
	public String getPay()
	{
		return pay;
	}
	public void setPay(String pay)
	{
		this.pay = pay;
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
	public ArrayList<BuyItemDTO> getBuyItemDTOList()
	{
		return buyItemDTOList;
	}
	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList)
	{
		this.buyItemDTOList = buyItemDTOList;
	}
}