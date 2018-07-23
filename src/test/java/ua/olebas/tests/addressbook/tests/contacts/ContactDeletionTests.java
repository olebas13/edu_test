package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {

	@Test
	public void testContactDeletion() {
		app.getNavigationHelper().gotoContactPage();
		app.getContactHelper().selectContact();
		app.getContactHelper().deleteSelectedContacts();
	}
}
