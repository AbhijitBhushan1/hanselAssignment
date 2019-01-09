package bank.login.com.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	WebDriver driver = null;

	WebDriverWait wait = null;

	public WebDriver getDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/driverexecutables/chromedriver");

			driver = new ChromeDriver();

		}

		wait = new WebDriverWait(driver, 60);

		return driver;

	}

	public void waitCondition(String locator) {

		if (locator.isEmpty()) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
			return;

		}
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(locator)));

	}

	public void moveToElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();

	}

	public void clickElement(String strategy, String locator) {

		switch (strategy) {
		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).click();
			;
			break;

		case "css":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
			driver.findElement(By.cssSelector(locator)).click();
			;
			break;
		case "tagName":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(locator)));
			driver.findElement(By.tagName(locator)).click();
			;
			break;

		case "linkText":
			System.out.println("BaseTest.clickElement()");
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
			driver.findElement(By.linkText(locator)).click();
			;
			break;

		default:
		}

	}

}
