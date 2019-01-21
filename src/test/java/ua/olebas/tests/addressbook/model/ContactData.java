package ua.olebas.tests.addressbook.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ContactData {

	private int id;
	private String firstname;
	private String lastname;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String group;
	private Set<GroupData> groups = new HashSet<GroupData>();

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getGroup() {
		return group;
	}

	public Groups getGroups() {
		return new Groups(groups);
	}

	public int getId() {
		return id;
	}

	public ContactData withId(int id) {
		this.id = id;
		return this;
	}

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}


	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactData that = (ContactData) o;
		return id == that.id &&
				Objects.equals(firstname, that.firstname) &&
				Objects.equals(lastname, that.lastname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstname, lastname);
	}

	@Override
	public String toString() {
		return "ContactData{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", homePhone='" + homePhone + '\'' +
				", mobilePhone='" + mobilePhone + '\'' +
				", workPhone='" + workPhone + '\'' +
				", group='" + group + '\'' +
				'}';
	}


}
