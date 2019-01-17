package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().contactPage();
		if (app.contact().list().size() == 0) {
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
		List<ContactData> before = app.contact().list();
		int index = before.size() - 1;
		app.contact().delete(index);
		app.goTo().contactPage();
		List<ContactData> after = app.contact().list();
		before.remove(index);
		Assert.assertEquals(after.size(), before.size());
        Assert.assertEquals(after, before);
	}


}
