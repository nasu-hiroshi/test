package com.internousdev.ecsite3.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite3.dao.BuyItemDAO;
import com.internousdev.ecsite3.dao.LoginDAO;
import com.internousdev.ecsite3.dao.UserCreateCompleteDAO;
import com.internousdev.ecsite3.dto.BuyItemDTO;
import com.internousdev.ecsite3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware
{
	private String loginUserId;
	private String loginPassword;
	private Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private List<BuyItemDTO> buyItemDTOList;

	String result;

	public String execute() throws SQLException
	{

		result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg())
		{
			buyItemDTOList = buyItemDAO.getBuyItemInfo();

			session.put("buyItemDTOList", buyItemDTOList);
			session.put("id", buyItemDTO.getId());
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("userName", loginDTO.getUserName());

			result = SUCCESS;
		}
		else
		{
			String guestUserId = RandomStringUtils.randomAlphabetic(8);
			String guestPassword = RandomStringUtils.random(1,"123456789") + RandomStringUtils.randomNumeric(8);
			String guestName = "ゲスト";
			UserCreateCompleteDAO guestUserCreate = new UserCreateCompleteDAO();
			guestUserCreate.createUser(guestUserId, guestPassword, guestName);

			loginDTO = loginDAO.getLoginUserInfo(guestUserId, guestPassword);
			loginDTO.setLoginFlg(false);

			session.put("loginUser", loginDTO);

			buyItemDTOList = buyItemDAO.getBuyItemInfo();

			session.put("buyItemDTOList", buyItemDTOList);
			session.put("id", buyItemDTO.getId());
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("userName", loginDTO.getUserName());

			result = SUCCESS;
		}
		return result;
	}
	public String guestExecute()
	{
		return result;
	}
	public String getLoginUserId()
	{
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId)
	{
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword()
	{
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword)
	{
		this.loginPassword = loginPassword;
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
	public List<BuyItemDTO> getBuyItemDTOList()
	{
		return buyItemDTOList;
	}
	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList)
	{
		this.buyItemDTOList = buyItemDTOList;
	}
}
