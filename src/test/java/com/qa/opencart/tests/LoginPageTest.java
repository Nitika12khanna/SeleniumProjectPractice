package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Opencart.pages.AccountPage;
import com.qa.Opencart.util.Constants;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test (priority = 1)
	public void loginPageTitleTest()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.Login_Page_Title);
	}
	
	@Test (priority = 2)
	public void loginPageUtlTest()
	{
		String actualUrl=loginPage.getLoginPageUrl();
		Assert.assertTrue(actualUrl.contains(Constants.Login_Page_Url_Fraction));
	}
	
	@Test (priority = 3)
	public void forgotPWDExisttest()
	{
		Assert.assertTrue(loginPage.isForgotpwdLinkExists());
	}
	
	@Test (priority = 4)
	public void registerLinkExistText()
	{
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Test (priority = 5)
	public void loginTest()
	{
		AccountPage accPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		String accTitle=accPage.getAccPageTitle();
		Assert.assertEquals(accTitle, Constants.Account_Page_Title);
		Assert.assertTrue(accPage.isLogoutLinkExist());
	} 
	
	
		
	
	

}
