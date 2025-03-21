package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Action_Driver.Action;
import com.Base.BaseClass;

@Test
public class IndexPage extends BaseClass
{

	@FindBy(xpath = "//a[text()='Sign up']")
	WebElement signInBtn;
	
	@FindBy(id = "login2")   //xpath = "//a[text()='Log in']"
	WebElement logInBtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement Logo;
	
	@FindBy (xpath = "//a[@onclick='addToCart(1)']")
	WebElement addItem;
	
	@FindBy (xpath = "//a[text()='Cart']")
	WebElement clickCart;
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public SignInPage clickOnSignin()
	{
		Action.click(getDriver(), signInBtn);
		return new SignInPage();
	}
	public LoginPage clickOnLogin()
	{
		Action.fluentWait(logInBtn, 10);
		Action.click(getDriver(), logInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(getDriver(), Logo);
	}
	public String getIndexPageTitle()
	{
		String IndexPageTitle = getDriver().getTitle();
		return IndexPageTitle;
	}
	public String getCurrIndexUrl()
	{
		String indexpageUrl = getDriver().getCurrentUrl();
		return indexpageUrl; 
	}
	public  ProductPage addItemToCart()
	{
		
	Action.scrollByVisibilityOfElement(getDriver(), addItem);
		Action.click(getDriver(), addItem);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = getDriver().switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
		System.out.println("Alert handled successfully!");
		return new ProductPage(); 
		
	}
	public CartPage clickOnCart()
	{
		Action.click(getDriver(), clickCart);
		return new CartPage();
	}
	
}
