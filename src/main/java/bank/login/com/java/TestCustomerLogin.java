package bank.login.com.java;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCustomerLogin extends BaseTest {

	WebDriver driver = null;

	@org.testng.annotations.BeforeClass
	public void before() {
		driver = getDriver("chrome");
	}

	@Test(priority = 1)
	public void testLoginCustomer1() {

		driver.get("http://www.globalsqa.com/angularjs-protractor-practice-site");
		driver.manage().window().maximize();

		waitCondition("");

		WebElement element = driver.findElement(By.linkText("Banking"));
		moveToElement(element);

		clickElement("linkText", "Banking");

		///////////////////////////////////////////

		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Customer Login')]")));

		clickElement("xpath", "//button[contains(text(),'Customer Login')]");

	}

	@Test(priority = 2)
	public void customerLoggedIn() throws InterruptedException {
		waitCondition("select");
		Select select = new Select(driver.findElement(By.id("userSelect")));
		// select by visible text could have been parameterized
		select.selectByValue("1");

		// click login button
		clickElement("xpath", "/html/body/div/div/div[2]/div/form/button");

		wait.until(ExpectedConditions.elementToBeClickable(By.name("accountSelect")));
		Select accountSelect = new Select(driver.findElement(By.name("accountSelect")));
		accountSelect.selectByVisibleText("1002");

		// transactions/Deposits and Withdrwal could have been parameterized
		String clikableAccount = "Transactions";

	}

}
