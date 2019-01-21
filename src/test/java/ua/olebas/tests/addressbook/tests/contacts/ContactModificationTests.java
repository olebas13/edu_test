package ua.olebas.tests.addressbook.tests.contacts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.appmanager.TestBase;
import ua.olebas.tests.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
		Contacts before = app.contact().all();
		ContactData modifiedContact = before.iterator().next();
		ContactData contact = new ContactData()
				.withId(modifiedContact.getId())
				.withFirstname("Oleg")
				.withLastname("Gykac")
				.withPhone("1231234345");
		app.contact().modify(contact);
//		assertThat(app.contact().count(), equalTo(before.size()));
		Contacts after = app.contact().all();
//		assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
	}

}
