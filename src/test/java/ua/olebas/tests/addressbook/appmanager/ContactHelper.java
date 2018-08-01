package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.olebas.tests.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


	public ContactHelper(WebDriver driver) {
		super(driver);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contactData, boolean creation) {
		type(By.name("firstname"), contactData.getFirstname());
		type(By.name("lastname"), contactData.getLastname());
		type(By.name("mobile"), contactData.getPhone());

		if (creation) {
			new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
		} else {
			Assert.assertFalse(isElementPresent(By.name("new_group")));
		}
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToContactPage() {
		click(By.linkText("home page"));
	}

	public void initContactModification() {
		click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
	}

	public void selectContact() {
		click(By.name("selected[]"));
	}

	public void deleteSelectedContacts() {
		click(By.xpath("//input[@value='Delete']"));
		isAlertPresent();
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	}
}
