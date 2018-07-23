package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

	private WebDriver driver;

	private SessionHelper sessionHelper;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private String browser;

	public ApplicationManager(String browser) {
		this.browser = browser;
	}

	public void init() {
		if (browser == BrowserType.FIREFOX) {
			driver = new FirefoxDriver();
		} else if (browser == BrowserType.CHROME) {
			driver = new ChromeDriver();
		} else if (browser == BrowserType.EDGE) {
			driver = new EdgeDriver();
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost/addressbook/");
		groupHelper = new GroupHelper(driver);
		contactHelper = new ContactHelper(driver);
		navigationHelper = new NavigationHelper(driver);
		sessionHelper = new SessionHelper(driver);
		sessionHelper.login("admin", "secret");
	}

	public void stop() {
		driver.quit();
	}

	public GroupHelper getGroupHelper() {
		return groupHelper;
	}

	public NavigationHelper getNavigationHelper() {
		return navigationHelper;
	}

	public ContactHelper getContactHelper() {
		return contactHelper;
	}
}
