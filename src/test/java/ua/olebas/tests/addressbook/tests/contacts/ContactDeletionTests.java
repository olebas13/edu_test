package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.appmanager.TestBase;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().contactPage();
		if (app.contact().all().size() == 0) {
			app.contact().create(new ContactData()
							.withFirstname("Olebas")
							.withLastname("Gykach")
							.withPhone("0683264327")
							.withGroup("group1"),
					true);
		}
	}

	@Test
	public void testContactDeletion() throws InterruptedException {
		Set<ContactData> before = app.contact().all();
		ContactData deletedContact = before.iterator().next();
		app.contact().delete(deletedContact);
		app.goTo().contactPage();
		Set<ContactData> after = app.contact().all();
		Assert.assertEquals(after.size(), before.size() - 1);
		before.remove(deletedContact);
        Assert.assertEquals(after, before);
	}


}
