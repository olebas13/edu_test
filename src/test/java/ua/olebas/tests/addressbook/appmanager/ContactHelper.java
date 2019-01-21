package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

	private Contacts contactCache = null;

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
		type(By.name("home"), contactData.getHomePhone());
		type(By.name("mobile"), contactData.getMobilePhone());
		type(By.name("work"), contactData.getWorkPhone());

		if (creation) {
			if (contactData.getGroups().size() > 0) {
				Assert.assertTrue(contactData.getGroups().size() == 1);
				new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
			}
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

	public void submitContactDeletion() {
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

    public int count() {
	    return driver.findElements(By.name("selected[]")).size();
    }

	public Contacts all() {
		if (contactCache != null) {
			return new Contacts(contactCache);
		}
		contactCache = new Contacts();
		List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement elem : elements) {
			int id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
			String firstname = elem.findElement(By.xpath("./td[3]")).getText();
			String lastname = elem.findElement(By.xpath("./td[2]")).getText();
			String allPhones = elem.findElement(By.xpath("./td[6]")).getText();
			String[] phones = allPhones.split("\n");
			contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
					.withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
		}

		return new Contacts(contactCache);
	}

	public void delete(ContactData contact) {
		selectContactById(contact.getId());
		deleteSelectedContacts();
		submitContactDeletion();
	}

	private void selectContactById(int id) {
		driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
	}

	public void initContactModificationById(int id) {
		WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
		WebElement row = checkbox.findElement(By.xpath("./../.."));
		List<WebElement> cells = row.findElements(By.tagName("td"));
		cells.get(7).findElement(By.tagName("a")).click();
	}

	public void modify(ContactData contact) {
		initContactModificationById(contact.getId());
		fillForm(contact, false);
		submitContactModification();
		returnToContactPage();
	}

	public ContactData infoFromEditForm(ContactData contact) {
		initContactModificationById(contact.getId());
		String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
		String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
		String home = driver.findElement(By.name("home")).getAttribute("value");
		String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
		String work = driver.findElement(By.name("work")).getAttribute("value");
		driver.navigate().back();
		return new ContactData()
				.withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
				.withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
	}
}
