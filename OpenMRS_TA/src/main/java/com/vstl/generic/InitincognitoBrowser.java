package com.vstl.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vstl.baseHelper.InitEnvironment;
;

public class InitincognitoBrowser extends InitEnvironment {

	private  WebDriver driver;
	
	@Override
	public WebDriver initEnv(String browser) {
		
		Pojo.setBrowser(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			System.out.println("chrome browser is opened");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("firefox browser is opened");
		}
		
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println("Edge browser is opened");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

	
	
		
	}



