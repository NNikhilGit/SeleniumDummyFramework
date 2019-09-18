package selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;

import conm.qa.Utility.TestUtil;

public class Assignment extends TestBase {
	LoginPage loginPage;
	String sheetname = "LoginPage";

	@DataProvider
	public Object[][] getLoginData() {

		Object data[][] = TestUtil.getTestData(sheetname);
		return data;

	}

	@BeforeMethod
	public void setup() {

		intialization();

		loginPage = new LoginPage();
		

	}

	@Test(dataProvider = "getLoginData")
	public void smokeloginTestCase(String pwd, String uname) throws InterruptedException {
		loginPage.loginPage(pwd, uname);
		String title = driver.getTitle();
		Assert.assertEquals(title, "LoginPage");

		System.out.println("test");
	}

	@Test(enabled = false)
	public void logOut() {

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
