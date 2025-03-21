package com.TestScripts;


import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.PageObjects.ProductPage;

public class HomePageTest extends BaseClass
{
	HomePage homepage;
	LoginPage loginpage;
	WebDriverWait wait;
	IndexPage indexpage;
	ProductPage productpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	@Test(groups = "Smoke")
	public void Categories() throws InterruptedException
	{
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		indexpage   = new IndexPage();
		 loginpage = indexpage.clickOnLogin();
		 
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		  loginpage = new LoginPage();
		 homepage = loginpage.logPage(prop.getProperty("username"),prop.getProperty("password"));
		 
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 homepage = new HomePage();
		 homepage = homepage.clickPhones();
		 System.out.println("phones clicked");
		 
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		  productpage = new ProductPage();
		 productpage = homepage.clickOnItem();
		 System.out.println("phone s6 clicked");
		

		String actUrl = productpage.getCurrProductpageUrl();
	    Assert.assertEquals(actUrl, "https://www.demoblaze.com/prod.html?idp_=1");
	   
	}

}
