package com.vstl.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pojo {

	private static String browser;
	private static SeleniumWrapperFunctions objSeleniumWrapperFunctions;
	private static WebDriver driver;
	private static String baseUrl;
	private static WebDriverWait WebdriverWait ;
	private static TestUtils objTestUtils;
	
	public static String getBrowser() {
		return browser;
	}
	public static void setBrowser(String browser) {
		Pojo.browser = browser;
	}
	public static SeleniumWrapperFunctions getObjSeleniumWrapperFunctions() {
		return objSeleniumWrapperFunctions;
	}
	public static void setObjSeleniumWrapperFunctions(SeleniumWrapperFunctions objSeleniumWrapperFunctions) {
		Pojo.objSeleniumWrapperFunctions = objSeleniumWrapperFunctions;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		Pojo.driver = driver;
	}
	public static String getBaseUrl() {
		return baseUrl;
	}
	public static void setBaseUrl(String baseUrl) {
		Pojo.baseUrl = baseUrl;
	}
	public static WebDriverWait getWebdriverWait() {
		return WebdriverWait;
	}
	public static void setWebdriverWait(WebDriverWait webdriverWait) {
		WebdriverWait = webdriverWait;
	}
	public static TestUtils getObjTestUtils() {
		return objTestUtils;
	}
	public static void setObjTestUtils(TestUtils objTestUtils) {
		Pojo.objTestUtils = objTestUtils;
	}
	

	

}
