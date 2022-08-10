package com.qa.Opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *  
 * @author DELL
 *
 */
public class DriverFactory {

	 WebDriver driver;
	 Properties prop;
	 OptionsManager optionsManager;
	 public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();  
	/**
	 * this method is used to initialize the driver on the basis of given browsername
	 * @param browsername
	 * @return this method will return the WebDriver
	 *
	 */
	public WebDriver init_driver(Properties prop)
	{
		String browsername= prop.getProperty("browser").trim();
		System.out.println("browser name is "+ browsername);
		
		optionsManager =new OptionsManager(prop);
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver(optionsManager.getChromeOptions());		
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver(optionsManager.getFirefoxOptions());	
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browsername.equalsIgnoreCase("safari"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver ();	
		}
		else 
		{
			System.out.println("Please pass the correct browser name..." + browsername);
			
		}
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	public synchronized WebDriver getDriver()
	{
		return tlDriver.get(); //it
		//will give the local copies of particular thread.
	}
	
	/**
	 * This method is ued to initialize the properties from the respective config file.
	 * @return this return properties class object with all the config properties
	 */
	public Properties init_prop()
	{
		try {
			FileInputStream ip=new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenshot()
	{
		File SrcFile= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path ="./screenshot"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(SrcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}


