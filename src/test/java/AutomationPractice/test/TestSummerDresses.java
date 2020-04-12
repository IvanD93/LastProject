package AutomationPractice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AutomationPractice.pageObject.HomePage;
import AutomationPractice.pageObject.Menu;
import AutomationPractice.pageObject.SummerDresses;

public class TestSummerDresses {
	private static WebDriver driver;

	@BeforeClass 
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod 
	public static void goToHomePage() {
		HomePage.openHomePage(driver);
		driver.manage().window().maximize();
	}

	@AfterClass 
	public void closeDriver() {
		driver.close();
	}

	@Test
	public void addDressToCard() {
		Menu.hoverToMainMenu(driver, "women");
		Menu.submenuClick(driver, "Summer Dresses");
		SummerDresses.clickOnFirstDress(driver);
		SummerDresses.quantity(driver);
		SummerDresses.sizeM(driver);
		SummerDresses.colorBlue(driver);
		SummerDresses.addToCard(driver);
		SummerDresses.goToCard(driver);

		SoftAssert sa = new SoftAssert();

		String actualQuantity = SummerDresses.dressAddedQuantity(driver);
		String expectedQuantity = "2";
		sa.assertEquals(actualQuantity, expectedQuantity);

		String actualColorSize = SummerDresses.dressAddedColorSize(driver);
		String expectedColor = "Blue";
		String expectedSize = "M";

		sa.assertTrue(actualColorSize.contains(expectedColor));
		sa.assertTrue(actualColorSize.contains(expectedSize));

		String actualName = SummerDresses.dressAddedName(driver);
		String expectedName = "Printed Summer Dress";
		sa.assertEquals(actualName, expectedName);

		sa.assertAll();
	}
}