package com.TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObjects.IndexPage;

public class IndexPageTest extends BaseClass
{
	IndexPage indexpage;
	
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
	public void verifyLogo()
	{
		indexpage = new IndexPage();
		boolean result = indexpage.validateLogo();
		Assert.assertTrue(result);
	}
    @Test(groups = "Smoke")
	public void verifyTitle()
	{
		String actTitle = indexpage.getIndexPageTitle();
		Assert.assertEquals(actTitle, "STORE");
	}
	
}
