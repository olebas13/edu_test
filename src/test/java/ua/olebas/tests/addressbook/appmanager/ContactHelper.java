package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.olebas.tests.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


	public ContactHelper(WebDriver driver) {
		super(driver);
	}

	public void initContactCreation() {
		click(By.linkText("ADD_NEW"));
	}

	public void addNext() {
		click(By.linkText("add next"));
	}

	public void fillForm(ContactData contactData, boolean creation) {
		type(By.name("firstname"), contactData.getFirstname());
		type(By.name("lastname"), contactData.getLastname());
		type(By.name("mobile"), contactData.getPhone());

		if (creation) {
			new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
		} else {
			Assert.assertFalse(isElementPresent(By.name("new_group")));
		}
	}

	public void submit() {
		click(By.name("submit"));
	}

	public void returnToContactPage() {
		click(By.linkText("home page"));
	}

	public void initContactModification(int i) {
		click(By.xpath("//table[@id='maintable']/tbody/tr["+i+"]/td[8]/a/img"));
	}

	public void selectContact(int index) {
		driver.findElements(By.name("selected[]")).get(index).click();
	}

	public void deleteSelectedContacts() {
		click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
	}

	public void submitComtactDeletion() {
		alertAccept();
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='UPDATE']"));
	}

	public boolean isThereAContact() {
		return isElementPresent(By.name("selected[]"));
	}

	public void create(ContactData contact, boolean creation) {
		initContactCreation();
		fillForm(contact, creation);
		submit();
		returnToContactPage();
	}

	public void modify(int index, ContactData contact) {
		initContactModification(index);
		fillForm(contact, false);
		submitContactModification();
		returnToContactPage();
	}

	public void delete(int index) {
		selectContact(index);
		deleteSelectedContacts();
		submitComtactDeletion();
	}

    public int getContactCount() {
	    return driver.findElements(By.name("selected[]")).size();
    }

	public List<ContactData> list() {
		List<ContactData> contacts = new ArrayList<>();
		List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
		for(WebElement elem: elements){
			int id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
			String firstname = elem.findElement(By.xpath("./td[3]")).getText();
			String lastname = elem.findElement(By.xpath("./td[2]")).getText();
			contacts.add(new ContactData(id,firstname,lastname));

		}
		return contacts;

	}
}
