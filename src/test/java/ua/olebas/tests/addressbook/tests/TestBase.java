package ua.olebas.tests.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.olebas.tests.addressbook.appmanager.ApplicationManager;

public class TestBase {


	protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

	@BeforeSuite
	public void setUp() {
		app.init();
	}

	@AfterSuite
	public void tearDown() {
		app.stop();
	}

}
