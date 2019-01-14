package ua.olebas.tests.addressbook.model;

import java.util.Objects;

public class ContactData {

	private int id;
	private String firstname;
	private String lastname;
	private String phone;
	private String group;

	public ContactData(String firstname, String lastname, String phone, String group) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.group = group;
	}

	public ContactData(int id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPhone() {
		return phone;
	}

	public String getGroup() {
		return group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ContactData{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", phone='" + phone + '\'' +
				", group='" + group + '\'' +
				'}';
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
}
