package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {

	@Test
	public void testContactDeletion() throws InterruptedException {
		app.getNavigationHelper().gotoContactPage();
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("Olebas", "Gykach", "0683264327", "test1"), true);
		}
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().selectContact(before.size() - 1);
		app.getContactHelper().deleteSelectedContacts();
		app.getContactHelper().submitComtactDeletion();
		app.getNavigationHelper().gotoContactPage();
		List<ContactData> after = app.getContactHelper().getContactList();
		before.remove(before.size() - 1);
		Assert.assertEquals(after.size(), before.size());
        Assert.assertEquals(after, before);
	}
}
