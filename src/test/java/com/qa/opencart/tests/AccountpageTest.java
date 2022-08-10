package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.pages.AccountPage;

import com.qa.Opencart.pages.CommonsPage;
import com.qa.Opencart.util.Constants;
import com.qa.opencart.base.BaseTest;

public class AccountpageTest extends BaseTest {
	
	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		//accPage = new AccountPage(driver);
	}
	
	@Test
	
	public void aacountPageTitleTest()
	{
		Assert.assertEquals(accPage.getAccPageTitle(), Constants.Account_Page_Title);
		
	}
	
	@Test(enabled=false)
	public void accPageHeaderTest()
	{
		String accPageHeader= accPage.getAccPageHeader();
		System.out.println(accPageHeader);
		Assert.assertEquals(accPageHeader, Constants.Account_Page_Header);
	}
	@Test
	public void accPageSectionsHeaderTest() {
		List<String> actualAccSecList = accPage.getaccountSectionsList();
		System.out.println("Actual Acc Page Sections Headers: " + actualAccSecList);
		Collections.sort(actualAccSecList);
		Collections.sort(Constants.Accounts_Page_Section_HeaderList);
		Assert.assertEquals(actualAccSecList, Constants.Accounts_Page_Section_HeaderList);
		
}
	@Test
	public void isUserLoggedOutTest() {
		accPage.clickOnLogout();	
		Assert.assertEquals(loginPage.getLogoutMessage(), Constants.USER_LOGOUT_MESSAGE);
	}
	@DataProvider
	public Object[][] getProductName()
	{
		return new Object[][]
				{
			{"Macbook"},
			{"iMac"},
			{"Samsung"},
			{"Apple"}
				};	
	}
	@Test(dataProvider= "getProductName")
	public void searchTest(String productName)
	{
		commPage=new CommonsPage(driver);
		searchResultPage=commPage.doSearch(productName);
		String resultPageHeader=searchResultPage.getResultPageHeader();
		Assert.assertTrue(resultPageHeader.contains(productName));
	}
	
	@DataProvider
	public Object[][] getProductData()
	{
		return new Object[][]
				{
			{"Macbook", "MacBook Pro"},
			{"Macbook", "MacBook Air"},
			{"Samsung", "Samsung SyncMaster 941BW"},
			
				 };	
	}
	@Test(dataProvider="getProductData")
	public void productInfoTest(String productName, String mainProductName)
	{
		commPage=new CommonsPage(driver);
		searchResultPage=commPage.doSearch(productName);
		String resultPageHeader=searchResultPage.getResultPageHeader();
		productinfoPage=searchResultPage.SelectProductName(mainProductName); 
		String mainProductNameValue=productinfoPage.getMainProductName();
		Assert.assertEquals(mainProductNameValue, mainProductName);
	}
}
