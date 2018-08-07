package ua.olebas.tests.addressbook.tests.groups;

import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testDeletionGroup() {
		app.getNavigationHelper().gotoGroupPage();
		if (!app.getGroupHelper().isThereAGroup()) {
			app.getGroupHelper().createGroup(new GroupData("test1", null, null));
		}
		app.getGroupHelper().selectGroup();
		app.getGroupHelper().deleteSelectedGroups();
		app.getGroupHelper().returnToGroupPage();
	}

}
