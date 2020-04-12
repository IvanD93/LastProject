package AutomationPractice.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
	
	public static final String registrationURL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
	
	private static final String XPATH_CHECKOUT = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
	private static final String XPATH_MAIL = "//input[@id='email_create']";
	private static final String XPATH_CREATE_ACCOUNT_BTN = "//form[@id='create-account_form']//span[1]";
	private static final String XPATH_FIRSTNAME = "//input[@id='customer_firstname']";
	private static final String XPATH_LASTNAME = "//input[@id='customer_lastname']";
	private static final String XPATH_PASSWORD = "//input[@id='passwd']";
	private static final String XPATH_ADDRESS = "//input[@name='address1']";
	private static final String XPATH_CITY = "//input[@name='city']";
	private static final String STATES = "option";
	private static final String XPATH_POSTALCODE = "//input[@id='postcode']";
	private static final String XPATH_PHONE = "//input[@id='phone_mobile']";
	private static final String XPATH_ALIAS = "//input[@id='alias']";
	private static final String BTN = "submitAccount";
	
	private static WebElement webElem;
	
	
	public static String navigateToRegistrationPage(WebDriver driver) {
		webElem = driver.findElement(By.xpath(XPATH_CHECKOUT));
		webElem.click();
		return driver.getCurrentUrl();
	}

	
	public static String registrationFillIn(WebDriver driver, String mail) {
		
		webElem = driver.findElement(By.xpath(XPATH_MAIL));
				webElem.clear();
		webElem = driver.findElement(By.xpath(XPATH_MAIL));
		webElem.sendKeys(mail);
		webElem = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT_BTN));
		webElem.click();
		return driver.getCurrentUrl();
	}

	
	public static void insertFirstName(WebDriver driver, String name) {
		webElem = driver.findElement(By.xpath(XPATH_FIRSTNAME));
		webElem.clear();
		webElem.sendKeys(name);
	}
	
	
	public static void insertLastName(WebDriver driver, String surname) {
		webElem = driver.findElement(By.xpath(XPATH_LASTNAME));
		webElem.clear();
		webElem.sendKeys(surname);
	}
	
	
	public static void insertPassword(WebDriver driver, String password) {
		webElem = driver.findElement(By.xpath(XPATH_PASSWORD));
		webElem.clear();
		webElem.sendKeys(password);
	}

	
	public static void insertAddress(WebDriver driver, String address) {
		webElem = driver.findElement(By.xpath(XPATH_ADDRESS));
		webElem.clear();
		webElem.sendKeys(address);
	}

	
	public static void insertCity(WebDriver driver, String city) {
		webElem = driver.findElement(By.xpath(XPATH_CITY)); 
		webElem.clear();
		webElem.sendKeys(city);
	}

	
	public static void choseState(WebDriver driver, String state) {
		List<WebElement> states = driver.findElements(By.tagName(STATES));
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).getText().equals(state)) {
				states.get(i).click();
			}
		}
	}

	
	public static void insertZipCode(WebDriver driver, String zip) {
		webElem = driver.findElement(By.xpath(XPATH_POSTALCODE)); 
		webElem.clear();
		webElem.sendKeys(zip);
	}

	
	public static void choseCountry(WebDriver driver, String country) {
		if (country.equals("United States"))
			driver.findElement(By.xpath("//option[contains(text(),'United States')]")).click();
		else
			driver.findElement(By.xpath("//select[@id='id_country']//option[contains(text(),'-')]")).click();
	}

	
	public static void insertPhoneNum(WebDriver driver, String number) {
		webElem = driver.findElement(By.xpath(XPATH_PHONE));
		webElem.clear();
		webElem.sendKeys(number);
	}


	public static void insertAlias(WebDriver driver, String alias) {
		webElem = driver.findElement(By.xpath(XPATH_ALIAS)); 
		webElem.clear();
		webElem.sendKeys(alias);
	}
	
	
	public static void submitRegistration(WebDriver driver) {
		driver.findElement(By.id(BTN)).click();
	}

}