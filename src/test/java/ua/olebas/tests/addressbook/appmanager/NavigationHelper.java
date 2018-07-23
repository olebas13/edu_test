package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

	private WebDriver driver;

	public NavigationHelper(WebDriver driver) {
		super(driver);
	}

	public void gotoGroupPage() {
		click(By.linkText("GROUPS"));
	}

	public void gotoContactPage() {
		click(By.linkText("HOME"));
	}
}
