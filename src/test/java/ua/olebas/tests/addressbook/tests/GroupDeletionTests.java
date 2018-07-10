package ua.olebas.tests.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testDeletionGroup() {
		app.gotoGroupPage();
		app.selectGroup();
		app.deleteSelectedGroups();
		app.returnToGroupPage();
	}

}
