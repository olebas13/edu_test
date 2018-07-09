package ua.olebas.tests.addressbook;

public class GroupData {
	private final String mName;
	private final String mHeader;
	private final String mFooter;

	public GroupData(String name, String header, String footer) {
		mName = name;
		mHeader = header;
		mFooter = footer;
	}

	public String getName() {
		return mName;
	}

	public String getHeader() {
		return mHeader;
	}

	public String getFooter() {
		return mFooter;
	}
}
