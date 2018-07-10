package ua.olebas.tests.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {


	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost/addressbook/");
		login("admin", "secret");
	}

	private void login(String username, String password) {
		driver.findElement(By.name("user")).click();
		driver.findElement(By.name("user")).clear();
		driver.findElement(By.name("user")).sendKeys(username);
		driver.findElement(By.name("pass")).click();
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}

	protected void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData groupData) {
		driver.findElement(By.name("group_name")).click();
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
		driver.findElement(By.name("group_header")).click();
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
		driver.findElement(By.name("group_footer")).click();
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
	}

	protected void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void gotoGroupPage() {
		driver.findElement(By.linkText("GROUPS")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	protected void deleteSelectedGroups() {
		driver.findElement(By.name("delete")).click();
	}

	protected void selectGroup() {
		driver.findElement(By.name("selected[]")).click();
	}
}
