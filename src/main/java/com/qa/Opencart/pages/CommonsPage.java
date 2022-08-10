package com.qa.Opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.util.Constants;
import com.qa.Opencart.util.ElementUtil;

public class CommonsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	public CommonsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	
	public SearchResults doSearch(String productName)
	{
		WebElement searchEle = eleUtil.waitForElementVisible(search, Constants.Default_Element_Wait_Time_Out);
		searchEle.clear();
		searchEle.sendKeys(productName);
		eleUtil.doClick(searchIcon);
		return new SearchResults(this.driver);
	}
	
	
}
