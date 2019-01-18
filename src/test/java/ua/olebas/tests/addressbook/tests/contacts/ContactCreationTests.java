package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.appmanager.TestBase;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.goTo().contactPage();
		Contacts before = app.contact().all();
		app.contact().initContactCreation();
		ContactData contact = new ContactData()
				.withFirstname("Olebas")
				.withLastname("Gykach")
				.withPhone("0683264327")
				.withGroup("test1");
		app.contact().fillForm(contact, true);
		app.contact().submit();
		Contacts after = app.contact().all();
		assertThat(after.size(), equalTo(before.size() + 1));
		assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
	}
}
