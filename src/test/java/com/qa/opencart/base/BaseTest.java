package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.Opencart.factory.DriverFactory;
import com.qa.Opencart.pages.AccountPage;
import com.qa.Opencart.pages.CommonsPage;
import com.qa.Opencart.pages.LoginPage;
import com.qa.Opencart.pages.ProductInfoPage;
import com.qa.Opencart.pages.RegisterPage;
import com.qa.Opencart.pages.SearchResults;

public class BaseTest {
	
	DriverFactory df;
	protected Properties prop;
   public  WebDriver driver;
    
  protected LoginPage loginPage;
  protected AccountPage accPage; 
  protected CommonsPage commPage;
  protected SearchResults searchResultPage;
 protected ProductInfoPage productinfoPage;
 protected RegisterPage regPage;
 protected SoftAssert softAssert;

  
  
	@BeforeTest
	
	public void setup()
	{
		df=new DriverFactory();
		prop=df.init_prop();
		
		driver=df.init_driver(prop);  // call by refrence
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
	}
	
	@AfterTest
	
	public void Teardown()
	{
		driver.quit();
	}

}
