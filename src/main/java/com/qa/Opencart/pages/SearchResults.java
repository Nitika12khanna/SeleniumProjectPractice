package com.qa.Opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.util.Constants;
import com.qa.Opencart.util.ElementUtil;

public class SearchResults {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By resultsPageHeader = By.cssSelector("div#content h1");
	
	
	public SearchResults(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);

}
	
	public String getResultPageHeader()
	{
		return eleUtil.doGetElementText(resultsPageHeader);
	}
	
	public ProductInfoPage SelectProductName(String mainProductName)
	{
		WebElement mainProductEle =eleUtil.waitForElementVisible(By.linkText(mainProductName), Constants.Default_Element_Wait_Time_Out);
		mainProductEle.click();
		return new ProductInfoPage(this.driver);
		}
}