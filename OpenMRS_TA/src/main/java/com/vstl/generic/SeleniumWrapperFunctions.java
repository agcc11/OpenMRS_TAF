package com.vstl.generic;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumWrapperFunctions {

	public SeleniumWrapperFunctions() {
	}
	
	private void isElementVisible(By locator) throws NotFoundException {
		Pojo.getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("*************Explicit wait************");
	}
	
	private void FluentWaitMechanism(By locator)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(Pojo.getDriver())
			       .withTimeout(Duration.ofSeconds(AppWaits.MAX_FluentWait))
			       .pollingEvery(Duration.ofSeconds(AppWaits.Freq_FluentWait))
			       .ignoring(NoSuchElementException.class).ignoring(ElementNotInteractableException.class);
				WebElement webelement=	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				webelement.click();
		System.out.println("*************Fluent wait************");
	}
	
	public boolean setText(By locator, String strInputValue) {
		try {
			WebElement webelement = Pojo.getDriver().findElement(locator);
			webelement.clear();
			webelement.sendKeys(strInputValue);
			return true;
		} catch (Exception e) {
			System.out.println("Expection is :" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean click(By locator) {
		this.isElementVisible(locator);
		try {
			Pojo.getDriver().findElement(locator).click();
			return true;
		}
		catch(NoSuchElementException e)
		{
			this.FluentWaitMechanism(locator);
			return true;
		}
		catch (Exception e) {
			System.out.println("Expection is:  " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean clickByJavascript(By locator) {
		this.isElementVisible(locator);
		try {
			JavascriptExecutor js = (JavascriptExecutor) Pojo.getDriver();
			 js.executeScript("arguments[0].click();",locator);
			 return true;
		}
		catch (Exception e) {
			System.out.println("Expection is:  " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

	public void refreshPageMethod() {
		try {
			Pojo.getDriver().navigate().refresh();
		} catch (Exception e) {
			System.out.println("Expection is:  " + e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isDisplayed(By locator) {
		try {
			Pojo.getDriver().findElement(locator).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println("Expection is :" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
