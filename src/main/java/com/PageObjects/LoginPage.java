package com.PageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Action_Driver.Action;
import com.Base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "loginusername")
	WebElement L_UN;

	@FindBy(id = "loginpassword")
	WebElement L_PW;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement logIn;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this); // Extend base class
	}

	public HomePage logPage(String uname, String pswd) throws InterruptedException {
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

		Thread.sleep(3000);
		Action.type(L_UN, uname);
 
		Thread.sleep(3000);
		Action.type(L_PW, pswd);

		Action.click(getDriver(), logIn); // click on login btn

		getDriver().switchTo().window(mainWindow);
		System.out.println("Main Window Title: " + getDriver().getTitle());
		return new HomePage();
	}

}
