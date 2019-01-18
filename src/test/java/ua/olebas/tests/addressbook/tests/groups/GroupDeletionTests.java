package ua.olebas.tests.addressbook.tests.groups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.appmanager.TestBase;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().groupPage();
		if (app.group().all().size() == 0) {
			app.group().create(new GroupData().withName("test1"));
		}
	}

	@Test
	public void testDeletionGroup() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
		app.group().delete(deletedGroup);
		Groups after = app.group().all();

		assertThat(after.size(), equalTo(before.size() - 1));
		assertThat(after, equalTo(before.without(deletedGroup)));
	}

}
