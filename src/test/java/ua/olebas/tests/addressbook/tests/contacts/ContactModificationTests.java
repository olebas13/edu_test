package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

	@Test
	public void testContactModification() {
		app.getNavigationHelper().gotoContactPage();
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("Olebas", "Gykach", "0683264327", "test1"), true);
		}
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().initContactModification(before.size() + 1);
		ContactData contact = new ContactData("Olebas", "Gykach", "0683264327", "test1");
		app.getContactHelper().fillContactForm(contact, false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToContactPage();
		List<ContactData> after = app.getContactHelper().getContactList();
		before.remove(before.size() - 1);
		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		after.sort(byId);
		before.sort(byId);

        Assert.assertEquals(before, after);
	}
}
