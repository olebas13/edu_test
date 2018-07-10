package ua.olebas.tests.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testDeletionGroup() {
		gotoGroupPage();
		selectGroup();
		deleteSelectedGroups();
		returnToGroupPage();
	}

}
