package com.qa.Opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.util.Constants;
import com.qa.Opencart.util.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	// 1. private By locator:OR
	private By emailid=By.id("input-email");
	private	By Password=By.id("input-password");
	private By loginbtn=By.xpath("//input[@value='Login']");
	private By forgotPWdLink=By.linkText("Forgotten Password");
	private By registerLink=By.linkText("Register");
	private By accLogoutMessage = By.cssSelector("div#content h1");
	
	// 2. public page class constructor......
	
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	eleUtil= new ElementUtil(this.driver); 
	}
	
	//public page action/methods:
	
	public String getLoginPageTitle()
	{
		String title= eleUtil.waitForTitleIs(Constants.Login_Page_Title, Constants.Default_Time_Out);
				System.out.println("Login Page Title :" + title);
		return title;
	}
	
	public String getLoginPageUrl()
	{
		String url= eleUtil.waitForUrlContains(Constants.Login_Page_Url_Fraction, Constants.Default_Time_Out);
		System.out.println("Login Page Title :" + url);
		return url;
	}
	
	public boolean isForgotpwdLinkExists()
	{
		return eleUtil.waitForElementVisible(forgotPWdLink, Constants.Default_Element_Wait_Time_Out).isDisplayed();
	}
	
	public boolean isRegisterLinkExist()
	{
		return eleUtil.waitForElementVisible(registerLink, Constants.Default_Element_Wait_Time_Out).isDisplayed();
	}
	
	public AccountPage doLogin(String username, String password)
	{
	   eleUtil.waitForElementVisible(emailid, Constants.Default_Element_Wait_Time_Out).sendKeys(username);
	   eleUtil.doSendKeys(Password, password);
	   eleUtil.doClick(loginbtn);
	   
	
		return new AccountPage(driver);
	}
	
	public String getLogoutMessage() {
		String logoutMesg = eleUtil.waitForElementVisible(accLogoutMessage, Constants.Default_Element_Wait_Time_Out).getText();
		System.out.println("Logout successful mesg === " + logoutMesg);
		return logoutMesg;
	}
		public RegisterPage navigateToRegisterPage()
		{
			eleUtil.doClick(registerLink);
			return new  RegisterPage(driver);
		}
	


}
