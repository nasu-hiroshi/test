package com.internousdev.sample.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sample.dao.BuyItemDAO;
import com.internousdev.sample.dao.LoginDAO;
import com.internousdev.sample.dao.UserCreateCompleteDAO;
import com.internousdev.sample.dto.BuyItemDTO;
import com.internousdev.sample.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();

	private List<BuyItemDTO> itemList;

	public String execute() throws SQLException
	{
		String guestUserId = RandomStringUtils.randomAlphabetic(8);
		String guestPassword = RandomStringUtils.random(1,"123456789") + RandomStringUtils.randomNumeric(8);
		String guestName = "ゲスト";
		UserCreateCompleteDAO guestUserCreate = new UserCreateCompleteDAO();
		guestUserCreate.createUser(guestUserId, guestPassword, guestName);

		loginDTO = loginDAO.getLoginUserInfo(guestUserId, guestPassword);

		session.put("loginUser", loginDTO);

		itemList = buyItemDAO.getBuyItemInfo();

		session.put("itemList", itemList);
		session.put("login_user_id",loginDTO.getLoginId());
		session.put("userName", loginDTO.getUserName());


		return SUCCESS;
	}
	public Map<String, Object> getSession()
	{
		return session;
	}
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
	public List<BuyItemDTO> getItemList()
	{
		return itemList;
	}
	public void setItemList(List<BuyItemDTO> itemList)
	{
		this.itemList = itemList;
	}
}
