package AutomationPractice.pageObject;

import org.openqa.selenium.WebDriver;

public class HomePage {

	public static final String HOME_URL = "http://automationpractice.com/index.php";
	

	public static void openHomePage(WebDriver driver) {
		driver.get(HOME_URL);
	}


	public static void navigateToHomePage(WebDriver driver) {
		driver.navigate().to(HOME_URL);
	}

	
}
