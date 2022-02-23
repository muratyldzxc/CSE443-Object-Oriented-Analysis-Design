package emailAddressBook;

import java.util.Iterator;

/**
 * Holds information about personal email address
 * @author murat
 */
public class PersonalEmailAddress extends EmailAddress{
	
	/**
	 * Name of the person that own this personal email address
	 */
	String name;
	/**
	 * Email address of the person that own this personal email address
	 */
	String emailAddress;
	
	/**
	 * Create a personal email address with given parameters
	 * @param name will be set to name of personal email address
	 * @param emailAddress will be set to email Address of personal email address
	 */
	public PersonalEmailAddress(String name, String emailAddress) {
		this.name = name;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * Print email address
	 * @param tab will be needed for printing in nice format
	 */
	public void print(String tab) {
		System.out.print(tab);
		System.out.print(" (" + getName());
		System.out.println(", " + getEmailAddress() + ")");
	}
	
	/**
	 * Returns Null Iterator
	 */
	public Iterator<EmailAddress> createIterator() {
		return new NullIterator();
	}
}
