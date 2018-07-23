package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

	private WebDriver driver;

	private SessionHelper sessionHelper;
	private NavigationHelper navigationHelper;
	private GroupHelper groupsHelper;

	public void init() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost/addressbook/");
		groupsHelper = new GroupHelper(driver);
		navigationHelper = new NavigationHelper(driver);
		sessionHelper = new SessionHelper(driver);
		sessionHelper.login("admin", "secret");
	}

	public void stop() {
		driver.quit();
	}

	public GroupHelper getGroupsHelper() {
		return groupsHelper;
	}

	public NavigationHelper getNavigationHelper() {
		return navigationHelper;
	}
}
