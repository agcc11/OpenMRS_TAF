package com.vstl.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vstl.flows.LoginLogoutFlow;
import com.vstl.generic.AppConstants;
import com.vstl.generic.BaseTest;
import com.vstl.generic.Pojo;
import com.vstl.pagefactory.LoginPage;

public class LoginLogoutTest extends BaseTest {

	private LoginPage objLoginPage;
	private LoginLogoutFlow objLoginLogoutFlow;
	
	
	public void initmethod()
	{
		objLoginPage=new LoginPage();
		objLoginLogoutFlow=new LoginLogoutFlow();
	}

	@BeforeClass
	public void setup()
	{
		this.openbrowser("chrome", AppConstants.incognitoBrowserMode);
		this.initmethod();
	}
	
	@BeforeMethod
	public void preconditio()
	{
		Pojo.getObjSeleniumWrapperFunctions().refreshPageMethod();
	}
	
	@Test
	public void TCID_01_VerifyValidLoginCredentials()
	{
		objLoginLogoutFlow.doLogin(AppConstants.validusername,AppConstants.validpassword);
		objLoginLogoutFlow.logoutMethod();
	}
	
	@Test
	public void TCID_02_VerifyValidUsernameEmptyPassword()
	{
		objLoginLogoutFlow.doLogin(AppConstants.validusername,AppConstants.emptypassword);
		objLoginPage.checkErrorMsg();
	}
	@Test
	public void TCID_03_VerifyEmptyUsernameValidPassword()
	{
		objLoginLogoutFlow.doLogin(AppConstants.emptyusername,AppConstants.validpassword);
		objLoginPage.checkErrorMsg();
	}
	@AfterClass
	public void tearDown()
	{
		Pojo.getDriver().quit();
	}
}
