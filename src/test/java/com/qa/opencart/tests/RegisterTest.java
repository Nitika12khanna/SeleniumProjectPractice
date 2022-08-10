package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.util.Constants;
import com.qa.Opencart.util.ExcelUtil;
import com.qa.opencart.base.BaseTest;

public class RegisterTest extends BaseTest {
	
	@BeforeTest
	public void regSetUp()
	{
		regPage=loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterTestData()
	{
		Object regData[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
				
	}
	@Test(dataProvider="getRegisterTestData")
	public void userRegisterTest(String firstname, String lastname, String email, String telephone, String password, String subscribe)
	{
		Assert.assertTrue(regPage.userRegister(firstname,  lastname,  email,  telephone,  password, subscribe));
		
	}

}
