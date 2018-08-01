package ua.olebas.tests.addressbook.tests.groups;

import org.testng.annotations.*;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() {
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
	}

}

