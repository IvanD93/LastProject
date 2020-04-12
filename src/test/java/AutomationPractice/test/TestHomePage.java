package AutomationPractice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationPractice.pageObject.HomePage;
import AutomationPractice.pageObject.SummerDresses;

public class TestHomePage {

	private static WebDriver driver;
	private static String url;
	
	@BeforeClass 
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		url = "http://automationpractice.com/index.php";
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
	}
	
	@Test (priority = 0) 
	public void testOpeningHomePage() {
		AutomationPractice.pageObject.HomePage.openHomePage(driver);
		driver.manage().window().maximize();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = url;
		
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test (priority = 1) 
	public void testNavigateToHomePage() {
		HomePage.openHomePage(driver);
		driver.manage().window().maximize();
		driver.navigate().to(SummerDresses.SUMMER_DRESSES_URL);
		HomePage.navigateToHomePage(driver);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = url;
		
		Assert.assertEquals(actualURL, expectedURL);
	}
}