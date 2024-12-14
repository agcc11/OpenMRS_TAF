package com.vstl.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	private InitEnvBrowser objInitEnvBrowser;
	private InitincognitoBrowser objInitincognitoBrowser;
	private static SeleniumWrapperFunctions objSeleniumWrapperFunctions;
	private static WebDriver driver;
	private static WebDriverWait WebdriverWait ;
	private static TestUtils objTestUtils;

	public void openbrowser(String browser,String browserType )
	{
		if(browserType.equalsIgnoreCase("normal"))
		{
			objInitEnvBrowser=new InitEnvBrowser();
			driver=objInitEnvBrowser.initEnv(browser);
			
		}
		else
		{
			objInitincognitoBrowser=new InitincognitoBrowser();
			driver=objInitincognitoBrowser.initEnv(browser);
		}
		Pojo.setDriver(driver);
		Pojo.setBaseUrl(AppConstants.baseUrl);
		objSeleniumWrapperFunctions=new SeleniumWrapperFunctions();
		Pojo.setObjSeleniumWrapperFunctions(objSeleniumWrapperFunctions);
		WebdriverWait = new WebDriverWait(Pojo.getDriver(),Duration.ofSeconds(AppWaits.MAX_Wait));
		Pojo.setWebdriverWait(WebdriverWait);
		objTestUtils=new TestUtils();
		Pojo.setObjTestUtils(objTestUtils);
		driver.get(Pojo.getBaseUrl());
		
	}
}

