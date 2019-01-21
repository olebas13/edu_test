package ua.olebas.tests.addressbook.tests.contacts;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.appmanager.TestBase;
import ua.olebas.tests.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase {

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
	public void testContactDeletion() {
		Contacts before = app.contact().all();
		ContactData deletedContact = before.iterator().next();
		app.contact().delete(deletedContact);
		app.goTo().contactPage();
		assertThat(app.contact().count(), equalTo(before.size() - 1));
		Contacts after = app.contact().all();
		assertThat(after, equalTo(before.without(deletedContact)));
	}


}
