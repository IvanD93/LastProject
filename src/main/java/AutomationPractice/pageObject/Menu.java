package AutomationPractice.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Menu {

	private static final String XPATH_WOMEN = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	private static final String XPATH_DRESSES = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]";
	private static final String XPATH_WSUMMER_DRESSES = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
	private static final String XPATH_SUMMER_DRESSES = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]";
	private static WebElement menu;

	
	public static void hoverToMainMenu(WebDriver driver, String button) {
		switch (button) {
		case "women":
			menu = driver.findElement(By.xpath(XPATH_WOMEN)); 
			break;
		case "dresses":
			menu = driver.findElement(By.xpath(XPATH_DRESSES)); 
			break;
		default:
			break;
		}
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
	}

	
	public static String submenuClick(WebDriver driver, String link) {
		switch (link) {
		case "Summer Dresses":
			menu = driver.findElement(By.xpath(XPATH_WSUMMER_DRESSES)); 
			break;
		case "SUMMER DRESSES":
			menu = driver.findElement(By.xpath(XPATH_SUMMER_DRESSES));
			break;
		}
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
		menu.click();
		return driver.getCurrentUrl(); 
	}

}