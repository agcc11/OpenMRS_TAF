package com.vstl.pagefactory;

import java.awt.Point;

import org.openqa.selenium.By;

import com.vstl.generic.AppConstants;
import com.vstl.generic.Pojo;
import com.vstl.generic.TestUtils;

public class LoginPage {

	By loc_inp_username = By.xpath("//input[@id='username']");

	By loc_inp_password = By.xpath("//input[@id='password']");

	By loc_link_registrationDesk = By.xpath("//ul[@id='sessionLocation']/li[text()='Registration Desk']");

	By loc_btn_loginBtn = By.xpath("//input[@id='loginButton']");
	
	By loc_btn_logout=By.xpath("//a[contains(text(),'Logout')]");
	
	By loc_strmsg_errormsg = By.xpath("//input[@id='username']");
	
	public By loc_userCredentials(String strId)
	{
		return By.xpath ("//input[@id='"+strId+"']");
	}
	
	public void setUsername(String strLocatorID,String username)
	{
		Pojo.getObjTestUtils().loggerReport(Pojo.getObjSeleniumWrapperFunctions().setText(this.loc_userCredentials(strLocatorID),username), "Issue with setusrnameMethod");
	}
	public void setPassword(String strLocatorID,String password)
	{
		Pojo.getObjTestUtils().loggerReport(Pojo.getObjSeleniumWrapperFunctions().setText(this.loc_userCredentials(strLocatorID),password ), "Issue with setPasswordMethod");
		//Pojo.getObjSeleniumWrapperFunctions().setText(loc_inp_password,password);
	}
	public void clickOnRegistrationLink()
	{
		Pojo.getObjSeleniumWrapperFunctions().click(loc_link_registrationDesk);
	}
	
	public void clickOnLoginBtn()
	{
		Pojo.getObjSeleniumWrapperFunctions().click(loc_btn_loginBtn);
	}
	public void clickOnLogoutBtn()
	{
		Pojo.getObjSeleniumWrapperFunctions().click(loc_btn_logout);
	}
	public void checkErrorMsg()
	{
		Pojo.getObjSeleniumWrapperFunctions().isDisplayed(loc_strmsg_errormsg);
	}
	
	
	
}
