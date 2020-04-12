package AutomationPractice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AutomationPractice.pageObject.SignIn;
import AutomationPractice.pageObject.ExcelUtils;

public class TestSignIn {

	private static WebDriver driver;

	@BeforeClass 
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(SignIn.SIGN_IN_PAGE);
		driver.manage().window().maximize();
	}

	@AfterClass 
	public void closeDriver() {
		driver.close();
	}

	@Test(priority = 0)
	public void logIn() {

		SignIn.logIn(driver, "mejltestivan@gmail.com", "123456"); 

		String textBtn = SignIn.checkSignOutBTN(driver);
		String expectedBtnText = "Sign out";
		String firstLastName = SignIn.checkAccount(driver);
		String expectedName = "Ivan Damnjanovic"; 

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(textBtn, expectedBtnText);
		sa.assertEquals(firstLastName, expectedName);
		sa.assertAll();
	}

	@Test(priority = 1) 
	public void logOut() {
		SignIn.logOut(driver);
		String textBtn = SignIn.checkSignInBTN(driver);
		String expectedBtnText = "Sign in";
		Assert.assertEquals(textBtn, expectedBtnText); 
	}

	@Test(priority = 2) 
	public void logInMultipleUsers() {

		ExcelUtils.setExcell("RandomGeneratedUsers.xlsx");
		ExcelUtils.setWorkSheet(0);

		SoftAssert sa = new SoftAssert();

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {

			driver.navigate().to(SignIn.SIGN_IN_PAGE);

			SignIn.logIn(driver, ExcelUtils.getDataAt(i, 0), ExcelUtils.getDataAt(i, 3));

			String textBtn = SignIn.checkSignOutBTN(driver);
			String expectedBtnText = "Sign out";
			String firstLastName = SignIn.checkAccount(driver);
			String expectedName = ExcelUtils.getDataAt(i, 1) + " " + ExcelUtils.getDataAt(i, 2);

			sa.assertEquals(textBtn, expectedBtnText);
			sa.assertEquals(firstLastName, expectedName);

			SignIn.logOut(driver);
		}
		sa.assertAll();
	}
}