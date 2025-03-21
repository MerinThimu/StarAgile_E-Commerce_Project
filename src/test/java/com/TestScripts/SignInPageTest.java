package com.TestScripts;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObjects.IndexPage;
import com.PageObjects.SignInPage;

public class SignInPageTest extends BaseClass
{

    IndexPage indexpage;
    SignInPage signinpage;
	
    @Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(ITestResult result)
	{
		getDriver().quit();
	}
	@Test(groups = {"Smoke","Sanity"})
	public void signinTest() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		indexpage = new IndexPage(); 
		signinpage = indexpage.clickOnSignin();
		indexpage = signinpage.signPage(prop.getProperty("username"),prop.getProperty("password"));
		 String actUrl = indexpage.getCurrIndexUrl();
		 Assert.assertEquals(actUrl, "https://www.demoblaze.com/");
	}



}
