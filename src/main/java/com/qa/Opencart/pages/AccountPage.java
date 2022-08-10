package com.qa.Opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.util.Constants;
import com.qa.Opencart.util.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header = By.cssSelector("div#logo h1 a");
	private By accountSectionsHeader = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(this.driver);
	
		
	}

	public String getAccPageTitle() {
		return eleUtil.waitForTitleContains(Constants.Account_Page_Title, Constants.Default_Time_Out);
		
	}

	public String getAccPageUrl() {
		return eleUtil.waitForUrlContains(Constants.Account_Page_Url_Fraction, Constants.Default_Time_Out);
	}

	public String getAccPageHeader() {
		return eleUtil.waitForElementVisible(header, Constants.Default_Time_Out).getText();
		
	}
	
	public List<String>  getaccountSectionsList()
	{
		List<WebElement> accSecList= eleUtil.waitForElementsVisible(accountSectionsHeader, Constants.Default_Time_Out);
		List<String> accSecValList=new ArrayList<String>();
		for(WebElement e: accSecList)
		{   
			String text=e.getText();
		  accSecValList.add(text);
		}
		return accSecValList;

	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, Constants.Default_Element_Wait_Time_Out).isDisplayed();
	}

	public LoginPage clickOnLogout() {
		if (isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
			return new LoginPage(driver);
			
		}
		return null;
	}

	public boolean issearchExist() {
		return eleUtil.doIsDisplayed(search);
	}
}
