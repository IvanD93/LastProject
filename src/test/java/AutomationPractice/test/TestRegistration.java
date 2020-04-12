package AutomationPractice.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AutomationPractice.pageObject.HomePage;
import AutomationPractice.pageObject.Menu;
import AutomationPractice.pageObject.Registration;
import AutomationPractice.pageObject.SignIn;
import AutomationPractice.pageObject.SummerDresses;
import AutomationPractice.pageObject.ExcelUtils;

public class TestRegistration {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass 
	public void closeDriver() {
	driver.close();
	}

	@Test 
	public void createAccount() {
		
		HomePage.openHomePage(driver);
		driver.manage().window().maximize();
		Menu.hoverToMainMenu(driver, "women");
		Menu.submenuClick(driver, "Summer Dresses");
		SummerDresses.clickOnFirstDress(driver);
		SummerDresses.quantity(driver);
		SummerDresses.sizeM(driver);
		SummerDresses.colorBlue(driver);
		SummerDresses.addToCard(driver);
		SummerDresses.goToCard(driver);

		
		String actualURL = Registration.navigateToRegistrationPage(driver);
		String expectedURL = Registration.registrationURL;

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(actualURL, expectedURL);

		

		Registration.registrationFillIn(driver, "mejltestivan12@gmail.com"); 
																	
																	
		Registration.insertFirstName(driver, "Ivan");
		Registration.insertLastName(driver, "Damnjanovic");
		Registration.insertPassword(driver, "123456");
		Registration.insertAddress(driver, "Avenue 25");
		Registration.insertCity(driver, "Phoenix");
		Registration.choseState(driver, "Arizona");
		Registration.insertZipCode(driver, "85003");
		Registration.choseCountry(driver, "United States");
		Registration.insertPhoneNum(driver, "123456789");
		Registration.insertAlias(driver, "Avenue, 85000, 25");
		Registration.submitRegistration(driver);

		

		String textBtn = SignIn.checkSignOutBTN(driver);
		String expectedBtnText = "Sign out";
		String firstLastName = SignIn.checkAccount(driver);
		String expectedName = "Ivan Damnjanovic";

		sa.assertEquals(textBtn, expectedBtnText);
		sa.assertEquals(firstLastName, expectedName);

		sa.assertAll();

		SignIn.logOut(driver); 

	}

	
	  @Test public static void createMultipleAccounts() {
	  
	  driver.get(Registration.registrationURL);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  ExcelUtils.setExcell("RandomGeneratedUsers.xlsx");
	  ExcelUtils.setWorkSheet(0); SoftAssert sa = new SoftAssert();
	  
	  for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
	  
	  driver.navigate().to(Registration.registrationURL);
	  
	  Registration.registrationFillIn(driver, ExcelUtils.getDataAt(i, 0));
	  
	  Registration.insertFirstName(driver, ExcelUtils.getDataAt(i, 1));
	  Registration.insertLastName(driver, ExcelUtils.getDataAt(i, 2));
	  Registration.insertPassword(driver, ExcelUtils.getDataAt(i, 3));
	  Registration.insertAddress(driver, ExcelUtils.getDataAt(i, 4));
	  Registration.insertCity(driver, ExcelUtils.getDataAt(i, 5));
	  Registration.choseState(driver, ExcelUtils.getDataAt(i, 6));
	  Registration.insertZipCode(driver, ExcelUtils.getDataAt(i, 7));
	  Registration.choseCountry(driver, ExcelUtils.getDataAt(i, 8));
	  Registration.insertPhoneNum(driver, ExcelUtils.getDataAt(i, 9));
	  Registration.insertAlias(driver, ExcelUtils.getDataAt(i, 10));
	  Registration.submitRegistration(driver);
	  
	  String textBtn = SignIn.checkSignOutBTN(driver); String expectedBtnText =
	  "Sign out"; String firstLastName = SignIn.checkAccount(driver); String
	  expectedName = ExcelUtils.getDataAt(i, 1) + " " + ExcelUtils.getDataAt(i, 2);
	  
	  sa.assertEquals(textBtn, expectedBtnText); sa.assertEquals(firstLastName,
	  expectedName);
	  
	  SignIn.logOut(driver);
	  
	  } sa.assertAll(); }
	 
}