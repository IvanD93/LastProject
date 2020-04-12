package AutomationPractice.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
	public static final String SIGN_IN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private static final String ID_EMAIL = "email";
	private static final String ID_PASSWORD = "passwd";
	private static final String SIGN_IN_BTN = "SubmitLogin";
	private static final String XPATH_LOGOUT = "//a[@title='Log me out']"; ////*[@id="header"]/div[2]/div/div/nav/div[2]/a
	private static final String XPATH_ACCOUNT = "//a[@class='account']";
	private static final String XPATH_LOGIN = "//a[@class='login']";
	
	public static void logIn(WebDriver driver, String mail, String password) {
		
		WebElement webElem = driver.findElement(By.id(ID_EMAIL));
		webElem.click();
		webElem.sendKeys(mail);

		webElem = driver.findElement(By.id(ID_PASSWORD));
		webElem.click();
		webElem.sendKeys(password);

		webElem = driver.findElement(By.name(SIGN_IN_BTN));
		webElem.click();
	}
	
	
		public static String checkSignOutBTN(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_LOGOUT)).getText();
		}
	
	
		public static String checkAccount(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_ACCOUNT)).getText();
		}
		
		public static void logOut(WebDriver driver) {
			driver.findElement(By.xpath(XPATH_LOGOUT)).click();
		}
	
	
		public static String checkSignInBTN(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_LOGIN)).getText();
		}
}