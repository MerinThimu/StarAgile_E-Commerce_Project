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
import com.Utility.Log;

public class LoginPageTest extends BaseClass
{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
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
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() throws InterruptedException
	{
		Log.startTestCase("loginTest");
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		indexpage = new IndexPage(); 
		Log.info("User is going to click on LogIn");
		loginpage =indexpage.clickOnLogin();
		Log.info("Enter username and password");
	     homepage =	loginpage.logPage(prop.getProperty("username"),prop.getProperty("password"));
	    String actUrl = homepage.getCurrUrl();
	    Log.info("Verifying if user is able to Login");
	    Assert.assertEquals(actUrl, "https://www.demoblaze.com/");
	    Log.info("Login is success!");
	    Log.endTestCase("loginTest");
	}

}
