package com.PageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Action_Driver.Action;
import com.Base.BaseClass;


public class SignInPage extends BaseClass
{
	@FindBy(id = "sign-username")
	WebElement S_UN;
	
	@FindBy(id = "sign-password")
	WebElement S_PW;
	
	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signIn;
	
	public  SignInPage() {
		PageFactory.initElements(getDriver(), this); //Extend base class
	}
	
	public IndexPage signPage(String S_uname,String S_pswd) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		String mainWindow = getDriver().getWindowHandle();

		Set<String> allWindows = getDriver().getWindowHandles();

		// Switch to the new window
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				getDriver().switchTo().window(windowHandle);
				break;
			}
		}

		Action.type(S_UN, S_uname);

		Action.type(S_PW, S_pswd);

		Action.click(getDriver(), signIn); // click on signin btn

		getDriver().switchTo().window(mainWindow);
		System.out.println("Main Window Title: " + getDriver().getTitle());	
		return new IndexPage();
	}	

	
}
