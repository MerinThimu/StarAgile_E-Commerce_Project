package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.Action_Driver.Action;
import com.Utility.ExtentManager;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>(); //declare Threadlocal driver
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try
		{
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver:"+driver);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}

	
	public static void launchApp(String browserName)
	{

		if (browserName.contains("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			
			driver.set(new ChromeDriver());
		}
		else if (browserName.contains("FireFox"))
		{
			
			driver.set(new FirefoxDriver());
		} 
		else if (browserName.contains("Edge"))
		{
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		
		getDriver().get(prop.getProperty("url")); //Navigate to url from config.properties file

	}

	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	
}
