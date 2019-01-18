package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.appmanager.TestBase;

import java.util.Set;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.goTo().contactPage();
		Set<ContactData> before = app.contact().all();
		app.contact().initContactCreation();
		ContactData contact = new ContactData()
				.withFirstname("Olebas")
				.withLastname("Gykach")
				.withPhone("0683264327")
				.withGroup("test1");
		app.contact().fillForm(contact, true);
		app.contact().submit();
		Set<ContactData> after = app.contact().all();
		Assert.assertEquals(after.size(), before.size() + 1);

		contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
		before.add(contact);
		Assert.assertEquals(before, after);

	}
}
