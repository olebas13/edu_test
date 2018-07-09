package ua.olebas.tests.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTests {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost/addressbook/");
		driver.findElement(By.name("user")).clear();
		driver.findElement(By.name("user")).sendKeys("admin");
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys("secret");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}

	@Test
	public void testGroupCreation() throws Exception {
		driver.findElement(By.linkText("GROUPS")).click();
		driver.findElement(By.name("new")).click();
		driver.findElement(By.name("group_name")).click();
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys("test1");
		driver.findElement(By.name("group_header")).click();
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys("test2");
		driver.findElement(By.name("group_footer")).click();
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys("test3");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("group page")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
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

