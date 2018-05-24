package com.internousdev.ecsite3.action;

import java.sql.SQLException;

import com.internousdev.ecsite3.dao.UserDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport
{
	public String execute() throws SQLException
	{
		UserDeleteDAO guestDalete = new UserDeleteDAO();
		guestDalete.deleteUser("ゲスト");

		return SUCCESS;
	}
}
