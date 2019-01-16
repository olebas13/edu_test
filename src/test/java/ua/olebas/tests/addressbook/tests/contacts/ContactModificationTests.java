package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().contactPage();
		if (app.contact().list().size() == 0) {
			app.contact().create(new ContactData("Olebas", "Gykach", "0683264327", "test1"), true);
		}
	}

	@Test
	public void testContactModification() {
		List<ContactData> before = app.contact().list();
		int index = before.size();
		ContactData contact = new ContactData("Olebas", "Gykach", "0683264327", "test1");
		app.contact().modify(index + 1, contact);
		List<ContactData> after = app.contact().list();
		before.remove(index - 1);
		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		after.sort(byId);
		before.sort(byId);

//        Assert.assertEquals(before, after);
	}

}
