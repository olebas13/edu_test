package ua.olebas.tests.addressbook.tests.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.List;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testDeletionGroup() {
		app.getNavigationHelper().gotoGroupPage();
		if (!app.getGroupHelper().isThereAGroup()) {
			app.getGroupHelper().createGroup(new GroupData("test1", null, null));
		}
        List<GroupData> before = app.getGroupHelper().getGroupList();
		app.getGroupHelper().selectGroup(before.size() - 1);
		app.getGroupHelper().deleteSelectedGroups();
		app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() - 1);
	}

}
