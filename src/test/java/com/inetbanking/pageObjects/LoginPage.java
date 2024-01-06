package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;	//This is an instance variable of type WebElement that represents an input field on a web page. It is typically located and initialized using a method like @FindBy in a Page Object Model.
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "/hmtl/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname); //sendKeys() is a method provided by the WebElement interface in Selenium WebDriver. Used to simulate typing keyboard input into the associated input field.
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
