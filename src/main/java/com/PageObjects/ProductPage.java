package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Action_Driver.Action;
import com.Base.BaseClass;

public class ProductPage extends BaseClass
{
	@FindBy (xpath = "//a[text()='Add to cart']")
	WebElement addItem;
	
	@FindBy (xpath = "//a[text()='Cart']")
	WebElement clickCart;
	
	public  ProductPage() {
		PageFactory.initElements(getDriver(), this); //Extend base class
	}
	public boolean isAddItemBtnAvailable()
	{
		return Action.isDisplayed(getDriver(), addItem);
	}
	public  ProductPage addItemToCart() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
        Action.scrollByVisibilityOfElement(getDriver(), addItem);
        Thread.sleep(3000);
		Action.click(getDriver(), addItem);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		getDriver().navigate().to("https://www.demoblaze.com/cart.html#");
		return new CartPage();
	}
	public String getCurrProductpageUrl() {
		String productpageurl = getDriver().getCurrentUrl();
		return productpageurl; 
	}

}

