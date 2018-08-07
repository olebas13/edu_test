package ua.olebas.tests.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.olebas.tests.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {


	public GroupHelper(WebDriver driver) {
		super(driver);
	}

	public void returnToGroupPage() {
		click(By.linkText("group page"));
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void fillGroupForm(GroupData groupData) {
		type(By.name("group_name"), groupData.getName());
		type(By.name("group_header"), groupData.getHeader());
		type(By.name("group_footer"), groupData.getFooter());
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void deleteSelectedGroups() {
		click(By.name("delete"));
	}

	public void selectGroup(int index) {
	    driver.findElements(By.name("selected[]")).get(index).click();
	}

	public void initGroupModification() {
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}

	public boolean isThereAGroup() {
		return isElementPresent(By.name("selected[]"));
	}

	public void createGroup(GroupData group) {
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupPage();
	}

    public int getGroupCount() {
	    return driver.findElements(By.name("selected[]")).size();
    }
}
