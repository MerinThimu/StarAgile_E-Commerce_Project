package com.TestScripts;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObjects.CartDetailsPage;
import com.PageObjects.CartPage;
import com.PageObjects.HomePage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.PageObjects.ProductPage;
import com.Utility.Log;

public class CartDetailsPageTest extends BaseClass{
	
	CartDetailsPage cartdetailspage;
	HomePage homepage;
	LoginPage loginpage;
	CartPage cartpage;
	ProductPage productpage;
	IndexPage indexpage;
	WebDriverWait wait;
	
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
	@Test(groups = "Regression")
	public void purchase() throws InterruptedException
	{
		Log.startTestCase("purchase");
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 indexpage = new IndexPage();
		 Log.info("User is going to click on LogIn");
		 loginpage = indexpage.clickOnLogin();
		 
		 Log.info("Enter username and password");
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		  loginpage = new LoginPage();
		 homepage = loginpage.logPage(prop.getProperty("username"),prop.getProperty("password"));
		 
		
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 homepage = new HomePage();
		 homepage = homepage.clickPhones();
		 Log.info("phones clicked");
		 
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		  productpage = new ProductPage();
		 productpage = homepage.clickOnItem();
		 Log.info("phone s6 clicked");
		 
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		
		productpage = productpage.addItemToCart();
		Log.info("item added");
		
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 cartpage = new CartPage();
		cartpage = productpage.clickOnCart();
		Log.info("clicked on cart btn");

		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		cartdetailspage = cartpage.clickPlaceOrder();
		Log.info("Order placed!");

		
		 wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		cartdetailspage = new CartDetailsPage();
		homepage = cartdetailspage.Cart();
		homepage = cartdetailspage.purchase();
		Log.info("Purchased");
		
		String msg = cartdetailspage.validateMsg();
		System.out.println(msg);
		homepage = cartdetailspage.clickOK();
		Log.info("Clicked on OK");
		Thread.sleep(3000);
		
		getDriver().navigate().to("https://www.demoblaze.com/index.html");
		String actUrl = homepage.getCurrUrl();
		Assert.assertEquals(actUrl, "https://www.demoblaze.com/index.html");
		 Log.endTestCase("purchase");
	}
}
