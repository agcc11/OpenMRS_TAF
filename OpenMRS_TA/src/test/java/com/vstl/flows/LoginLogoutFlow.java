package com.vstl.flows;

import com.vstl.generic.AppConstants;
import com.vstl.generic.Applocators;
import com.vstl.pagefactory.LoginPage;

public class LoginLogoutFlow {

	
	private LoginPage objLoginPage;
	
	public LoginLogoutFlow()
	{
		objLoginPage=new LoginPage();
	}
	
	public void doLogin(String username,String password)
	{
		if(!username.equals(""))
			objLoginPage.setUsername(Applocators.strUsernameValue,username);
		if(!password.equals(""))
			objLoginPage.setPassword(Applocators.strPasswordValue,password);
		objLoginPage.clickOnRegistrationLink();
		objLoginPage.clickOnLoginBtn();
	}

	public void logoutMethod()
	{
		objLoginPage.clickOnLogoutBtn();
	}
}
