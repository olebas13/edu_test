package ua.olebas.tests.addressbook.tests.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.ContactData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.getNavigationHelper().gotoContactPage();
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().initContactCreation();
		ContactData contact1 = new ContactData("user1", "user2", "+380683264356", "test1");
		ContactData contact2 = new ContactData("user2", "user2", "+380647896541", "test1");
		app.getContactHelper().fillContactForm(contact1, true);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().addNextContact();
		app.getContactHelper().fillContactForm(contact2, true);
		app.getContactHelper().submitContactCreation();
		List<ContactData> after = app.getContactHelper().getContactList();

		Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
		contact1.setId(after.stream().max(byId).get().getId() - 1);
		contact2.setId(after.stream().max(byId).get().getId());
		before.add(contact1);
		before.add(contact2);
		Assert.assertEquals(after.size(), before.size());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(after, before);
	}
}
