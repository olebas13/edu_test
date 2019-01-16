package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(WebDriver driver) {
		super(driver);
	}

	public void groupPage() {
		if (isElementPresent(By.tagName("h1"))
				&& driver.findElement(By.tagName("h1")).equals("Groups")
				&& isElementPresent(By.name("new"))) {
			return;
		}
		click(By.linkText("GROUPS"));
	}

	public void contactPage() {
		if (isElementPresent(By.id("maintable"))) {
			return;
		}
		click(By.linkText("home"));
	}
}
