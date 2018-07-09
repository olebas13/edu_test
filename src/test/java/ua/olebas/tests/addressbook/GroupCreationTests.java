package ua.olebas.tests.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTests {
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

	@Test
	public void testGroupCreation() {
		gotoGroupPage();
		initGroupCreation();
		fillGroupForm(new GroupData("test1", "test2", "test3"));
		submitGroupCreation();
		returnToGroupPage();
	}

	private void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	private void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	private void fillGroupForm(GroupData groupData) {
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

	private void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	private void gotoGroupPage() {
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
}

