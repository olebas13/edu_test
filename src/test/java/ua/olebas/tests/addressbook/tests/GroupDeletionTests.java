package ua.olebas.tests.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testDeletionGroup() {
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupsHelper().selectGroup();
		app.getGroupsHelper().deleteSelectedGroups();
		app.getGroupsHelper().returnToGroupPage();
	}

}
