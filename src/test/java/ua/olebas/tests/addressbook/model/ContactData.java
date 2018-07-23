package ua.olebas.tests.addressbook.model;

public class ContactData {

	private final String firstname;
	private final String lastname;
	private final String phone;

	public ContactData(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
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
}
