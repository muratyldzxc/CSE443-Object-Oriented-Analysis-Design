package emailAddressBook;

import java.util.Iterator;

/**
 * The base class for personal emails and email groups
 * @author murat
 */
public abstract class EmailAddress {
	
	/**
	 * Returns name of the person that own this email address
	 */
	public String getName(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Returns email address of the person that own this email address
	 */
	public String getEmailAddress() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Add given email address to email group
	 * @param email will be added to email group
	 */
	public void add(EmailAddress email) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Remove given email address to email group
	 * @param email will be removed to email group
	 */
	public void remove(EmailAddress email) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Print email address
	 * @param tab will be needed for printing  in nice format
	 */
	public void print(String tab) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Return an Iterator
	 */
	public abstract Iterator<EmailAddress> createIterator();
	
}
