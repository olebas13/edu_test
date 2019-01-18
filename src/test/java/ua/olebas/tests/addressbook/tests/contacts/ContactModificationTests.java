package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.appmanager.TestBase;

import java.util.Set;

public class ContactModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().contactPage();
		if (app.contact().all().size() == 0) {
			app.contact().create(new ContactData()
					.withFirstname("Olebas")
					.withLastname("Gykach")
					.withPhone("0683264327")
					.withGroup("test1"),
					true);
		}
	}

	@Test
	public void testContactModification() {
		Set<ContactData> before = app.contact().all();
		ContactData modifiedContact = before.iterator().next();
		ContactData contact = new ContactData()
				.withId(modifiedContact.getId())
				.withFirstname("Olebas")
				.withLastname("Gykach")
				.withPhone("0683264327")
				.withGroup("group1");
		app.contact().modify(contact);
		Set<ContactData> after = app.contact().all();
//		Assert.assertEquals(after.size(), before.size());
		before.remove(modifiedContact);
		before.add(contact);

//        Assert.assertEquals(before, after);
	}

}
