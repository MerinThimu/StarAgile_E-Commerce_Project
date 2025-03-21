package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Action_Driver.Action;
import com.Base.BaseClass;

public class CartPage extends BaseClass
{
	@FindBy (xpath = "//button[text()='Place Order']")
	WebElement orderBtn;
	@FindBy (xpath = "//h5[text()='Place order']")
	WebElement title;
	
	public  CartPage() {
		PageFactory.initElements(getDriver(), this); //Extend base class
	}
	public CartDetailsPage clickPlaceOrder()
	{
		Action.click(getDriver(), orderBtn);
		//driver.switchTo().frame(0);
		return new CartDetailsPage();
	}
	public boolean verifyCartDetailsPage()
	{
		return Action.isDisplayed(getDriver(), title);
	}
	
	public String getCurrcartpageUrl() {
		String cartpageurl = getDriver().getCurrentUrl();
		return cartpageurl; 
	}
	
	

}
