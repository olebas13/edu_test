package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.getNavigationHelper().gotoContactPage();
		int before = app.getContactHelper().getContactCount();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactForm(new ContactData("Olebas", "Gykach", "0683264327", "test1"), true);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToContactPage();
		int after = app.getContactHelper().getContactCount();

        Assert.assertEquals(after, before + 1);
	}
}
