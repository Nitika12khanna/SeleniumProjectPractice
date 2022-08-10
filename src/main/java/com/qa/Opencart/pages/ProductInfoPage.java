package com.qa.Opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.util.Constants;
import com.qa.Opencart.util.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	 
	private By mainProductName=By.cssSelector("div#content h1");
	private By productImages=By.cssSelector("ul.thumbnails img");
	private By ProductDescription=By.cssSelector("div#tab-description");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(this.driver);
	}
	
	public String getMainProductName ()
	{
		return eleUtil.doGetElementText(mainProductName);
	}
	
	public int getProductImageCount()
	{
		return eleUtil.waitForElementsVisible(productImages, Constants.Default_Element_Wait_Time_Out).size();
	}
	
	public String getProductDescription()
	{
		return eleUtil.doGetElementText(ProductDescription);
	}
}
