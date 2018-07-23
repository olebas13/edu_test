package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.olebas.tests.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


	public ContactHelper(WebDriver driver) {
		super(driver);
	}

	public void initContactCreation() {
		click(By.linkText("ADD_NEW"));
	}

	public void fillContactForm(ContactData contactData) {
		type(By.name("firstname"), contactData.getFirstname());
		type(By.name("lastname"), contactData.getLastname());
		type(By.name("mobile"), contactData.getPhone());
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToContactPage() {
		click(By.linkText("home page"));
	}

	public void initContactModification() {
		click(By.xpath("//a[@href='edit.php?id=4']//img[@title='EDIT']"));
	}

	public void selectContact() {
		click(By.name("selected[]"));
	}

	public void deleteSelectedContacts() {
		click(By.xpath("//input[@value='DELETE']"));
		isAlertPresent();
	}
}
