package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Action_Driver.Action;
import com.Base.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy (xpath = "//a[text()='Phones']")
	WebElement phones;
	
	@FindBy (xpath = "//a[text()='Samsung galaxy s6']")
	WebElement phoneclick;
	
	public  HomePage() {
		PageFactory.initElements(getDriver(), this); //Extend base class
	}

	public HomePage clickPhones() throws InterruptedException
	{
	Action.scrollByVisibilityOfElement(getDriver(), phones);
	Thread.sleep(3000);
		Action.click(getDriver(), phones);
		
		return new HomePage();
		
	}
	public ProductPage clickOnItem() throws InterruptedException
	{
		Action.scrollByVisibilityOfElement(getDriver(), phones);
		Thread.sleep(3000);
		Action.click(getDriver(), phoneclick);
		getDriver().navigate().to("https://www.demoblaze.com/prod.html?idp_=1");
		return new ProductPage();
		
	}
	
	public String getCurrUrl()
	{
		String homepageUrl = getDriver().getCurrentUrl();
		return homepageUrl; 
	}

}
