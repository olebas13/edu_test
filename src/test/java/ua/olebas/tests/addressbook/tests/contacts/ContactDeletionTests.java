package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {

	@Test
	public void testContactDeletion() throws InterruptedException {
		app.getNavigationHelper().gotoContactPage();
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("Olebas", "Gykach", "0683264327", "test1"), true);
		}
		int before = app.getContactHelper().getContactCount();
		app.getContactHelper().selectContactForDelete();
		app.getContactHelper().deleteSelectedContacts();
        Thread.sleep(2000);
		int after = app.getContactHelper().getContactCount();


        Assert.assertEquals(after, before - 1);
	}
}
