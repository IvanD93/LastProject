package AutomationPractice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AutomationPractice.pageObject.HomePage;
import AutomationPractice.pageObject.Menu;

public class TestMenu {
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
	
	@BeforeMethod 
	public static void goToHomePage() {
		HomePage.openHomePage(driver);
		driver.manage().window().maximize();
	}
	
	@Test 
	public void testHoverWomen() {
		
		Menu.hoverToMainMenu(driver, "women");	
		String actualURL = Menu.submenuClick(driver, "Summer Dresses");
		String expectedURL = "http://automationpractice.com/index.php?id_category=11&controller=category";
		SoftAssert sa = new SoftAssert(); 
		sa.assertEquals(actualURL, expectedURL);
		sa.assertAll();
	}  
	
	@Test
	public void testHoverDresses() {
		
		AutomationPractice.pageObject.Menu.hoverToMainMenu(driver, "dresses");	
		String actualURL = Menu.submenuClick(driver, "SUMMER DRESSES");
		String expectedURL = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(actualURL, expectedURL);
	} 
	
	@Test 
	public void testEqualSummerDressesURL() {
		
		
		Menu.hoverToMainMenu(driver, "women");	
		String womenURL = Menu.submenuClick(driver, "Summer Dresses");
		Menu.hoverToMainMenu(driver, "dresses");
		String dressesURL = Menu.submenuClick(driver, "SUMMER DRESSES");
		Assert.assertTrue(womenURL.equals(dressesURL));
	}
}