package ua.olebas.tests.addressbook.tests.groups;

import org.testng.Assert;
import org.testng.annotations.*;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.tests.TestBase;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() {
		app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
		app.getGroupHelper().createGroup(new GroupData("test1", null, null));
		int after = app.getGroupHelper().getGroupCount();

        Assert.assertEquals(after, before + 1);
	}

}

