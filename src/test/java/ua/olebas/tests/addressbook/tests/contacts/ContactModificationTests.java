package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.appmanager.TestBase;
import ua.olebas.tests.addressbook.model.Contacts;

public class ContactModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().contactPage();
		if (app.contact().all().size() == 0) {
			app.contact().create(new ContactData()
					.withFirstname("Olebas")
					.withLastname("Gykach")
					.withHomePhone("0413595418")
					.withMobilePhone("0683264327")
					.withWorkPhone("0446668877")
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
				.withHomePhone("0413598748")
				.withMobilePhone("1231234345")
				.withWorkPhone("0447896541");
		app.contact().modify(contact);
//		assertThat(app.contact().count(), equalTo(before.size()));
		Contacts after = app.contact().all();
//		assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
	}

}
