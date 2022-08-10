package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Opencart.pages.CommonsPage;
import com.qa.Opencart.pages.LoginPage;
import com.qa.Opencart.pages.ProductInfoPage;
import com.qa.Opencart.util.DescriptionConstant;
import com.qa.opencart.base.BaseTest;

public class productInfoTest extends BaseTest{

	@BeforeClass
	
	public void productinfoSetup()
	{
		//loginPage=new LoginPage(driver);
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		commPage=new CommonsPage(driver);
		productinfoPage=new ProductInfoPage(driver);
		
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro", 4},
			{"Macbook", "MacBook Air", 4},
			{"Samsung", "Samsung SyncMaster 941BW", 1}
		};
	}
@Test
public void productImagesCountTest(String searchKey, String productName, int imagesCount) 
{
	
	searchResultPage=commPage.doSearch(searchKey);
	String resultPageHeader=searchResultPage.getResultPageHeader();
	productinfoPage=searchResultPage.SelectProductName(productName); 
	Assert.assertEquals(productinfoPage.getProductImageCount(),imagesCount);
	}

@Test
public void productDescriptionTest() {
	searchResultPage = commPage.doSearch("Macbook");
	productinfoPage = searchResultPage.SelectProductName("MacBook Air");
	String productDesc = productinfoPage.getProductDescription();
	System.out.println("product desc: " + productDesc);
	
	softAssert.assertTrue(productDesc!=null);
	softAssert.assertFalse(productDesc.isEmpty());
	softAssert.assertTrue(productDesc.contains(DescriptionConstant.MacBook_Air_Description));
	softAssert.assertAll();
	
	//hash doesnot maintaqin the order
//	it doesnot follow the index
	//hashmap is a class having parent map
}
}
