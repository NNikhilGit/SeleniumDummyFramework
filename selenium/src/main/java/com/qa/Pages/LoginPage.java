package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait;
	@FindBy(xpath = "//*[@id=\"nav-main\"]/li[6]/a")
	private WebElement loginBtn;

	@FindBy(xpath = "//label[contains(text(),'Email')]//following::input[1]")
	WebElement UnameTxtField;

	@FindBy(xpath = "//label[contains(text(),'Email')]//following::input[2]")
	WebElement pwdField;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginPage(String uname, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));	
		loginBtn.click();
		UnameTxtField.sendKeys(uname);
		pwdField.sendKeys(pwd);
	}

}
