package ua.olebas.tests.addressbook.tests.groups;

import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class GroupModificationTests extends TestBase {

	@Test
	public void testGroupModification() {
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().selectGroup();
		app.getGroupHelper().initGroupModification();
		app.getGroupHelper().fillGroupForm(new GroupData("test3", "test4", "test5"));
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
	}
}