package ua.olebas.tests.addressbook.tests.groups;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.tests.addressbook.model.GroupData;
import ua.olebas.tests.addressbook.tests.TestBase;

import java.util.List;

public class GroupDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().groupPage();
		if (app.group().list().size() == 0) {
			app.group().create(new GroupData().withName("test1"));
		}
	}

	@Test
	public void testDeletionGroup() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
		app.group().delete(index);
		List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
	}



}
