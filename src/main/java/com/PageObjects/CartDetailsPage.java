package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Action_Driver.Action;
import com.Base.BaseClass;

public class CartDetailsPage extends BaseClass {
	
	@FindBy (xpath = "//h2[text()='Thank you for your purchase!']")
	WebElement text;
	@FindBy (id = "name")
	WebElement name;
	@FindBy (id = "country") 
	WebElement country;
	@FindBy (id = "city")
	WebElement city;
	@FindBy (id = "card") 
	WebElement card;
	@FindBy (id = "month")
	WebElement month;
	@FindBy (id = "year") 
	WebElement year;
	
	@FindBy (xpath = "//button[text()='Place Order']")
	WebElement orderBtn;
	@FindBy (xpath = "//h5[text()='Place order']")
	WebElement title;
	@FindBy (xpath = "//button[text()='Purchase']")
	WebElement purchaseBtn;
	@FindBy (xpath = "//button[text()='OK']")
	WebElement okBtn;
	
	public  CartDetailsPage() 
	{
		PageFactory.initElements(getDriver(), this); //Extend base class
	}

	public HomePage Cart() throws InterruptedException
	{
		Action.type(name, "Merin");
		Action.type(country, "India");
		Action.type(city, "Kerala");
		Action.type(card, "123456789");
		Action.type(month, "November");
		Action.type(year, "2025");
		
		//driver.switchTo().alert().accept(); 
		return new HomePage();
	}	
	public CartDetailsPage clickPlaceOrder()
	{
		Action.click(getDriver(), orderBtn);
		return new CartDetailsPage();
	}
		public String validateMsg()
		{
		
		String confirmMsg = text.getText();
		return confirmMsg;
		
		}
		public HomePage purchase()
		{
			Action.click(getDriver(), purchaseBtn);
			return new HomePage();
		}
		public HomePage clickOK()
		{
			Action.click(getDriver(), okBtn);
			return new HomePage();
		}
		
	}
	
	
	
	
	

