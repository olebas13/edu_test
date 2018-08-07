package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class ContactModificationTests extends TestBase {

	@Test
	public void testContactModification() throws InterruptedException {
		app.getNavigationHelper().gotoContactPage();
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("Olebas", "Gykach", "0683264327", "test1"), true);
		}
		int before = app.getContactHelper().getContactCount();
		app.getContactHelper().initContactModification();
		app.getContactHelper().fillContactForm(new ContactData("Oleg", "Nevoyt", "1548464648647", null), false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToContactPage();
		Thread.sleep(2000);
		int after = app.getContactHelper().getContactCount();

        Assert.assertEquals(before, after - 1); // костыль
	}
}
