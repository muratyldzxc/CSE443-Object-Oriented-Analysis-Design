package emailAddressBook;

/**
 * Holds all personal and group emails
 * @author murat
 */
public class EmailAddressBook {
	
	/**
	 * Holds all personal and group emails
	 */
	EmailAddress allEmailAddresses;
	
	/**
	 * Create an Address Book
	 * @param allEmailAddresses Holds all personal and group emails
	 */
	public EmailAddressBook(EmailAddress allEmailAddresses) {
		this.allEmailAddresses = allEmailAddresses;
	}
	
	/**
	 * Print all personal and group emails
	 */
	public void printEmailAddressBook() {
		allEmailAddresses.print("");
	}
}
