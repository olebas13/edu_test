package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.appmanager.TestBase;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.goTo().contactPage();
		Contacts before = app.contact().all();
		app.contact().initContactCreation();
		File photo = new File("src/test/resources/texture_atlas.png");
		ContactData contact = new ContactData()
				.withFirstname("Olebas")
				.withLastname("Gykach")
				.withHomePhone("0413595418")
				.withMobilePhone("0683264327")
				.withWorkPhone("0441115558")
				.withPhoto(photo)
				.withGroup("test1");
		app.contact().fillForm(contact, true);
		app.contact().submit();
		assertThat(app.contact().count(), equalTo(before.size() + 1));
		Contacts after = app.contact().all();
		assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
	}

}
