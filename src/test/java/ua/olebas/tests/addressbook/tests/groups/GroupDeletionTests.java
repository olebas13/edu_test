package ua.olebas.tests.addressbook.tests.groups;

import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testDeletionGroup() {
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().selectGroup();
		app.getGroupHelper().deleteSelectedGroups();
		app.getGroupHelper().returnToGroupPage();
	}

}
