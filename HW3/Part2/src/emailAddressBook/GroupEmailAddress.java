package emailAddressBook;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Holds email addresses that belongs to group
 * @author murat
 */
public class GroupEmailAddress extends EmailAddress{
	
	/**
	 * Name of the group 
	 */
	String name;
	/**
	 * Group Email address 
	 */
	String emailGroupAddress;
	/**
	 * Holds email addresses in this group
	 */
	ArrayList<EmailAddress> emailGroupAddresses;
	
	/**
	 * Create email group with given parameters
	 * @param name of the group
	 * @param emailGroupAddress email address of the group
	 */
	public GroupEmailAddress(String name, String emailGroupAddress) {
		this.name = name;
		this.emailGroupAddress = emailGroupAddress;
		this.emailGroupAddresses = new ArrayList<EmailAddress>();
	}
	
	public String getName() {
		return name;
	}
	/*
	 * Returns email address of group
	 */
	public String getEmailGroupAddress() {
		return emailGroupAddress;
	}

	/**
	 * Returns email addresses belong to this group
	 * @return
	 */
	public ArrayList<EmailAddress> getEmailGroupAddresses() {
		return emailGroupAddresses;
	}

	/**
	 * Add email address to this group
	 */
	public void add(EmailAddress emailAddress) {
		emailGroupAddresses.add(emailAddress);
	}
	
	/**
	 * remove email address to this group
	 */
	public void remove(EmailAddress emailAddress) {
		emailGroupAddresses.remove(emailAddress);
	}
	
	/**
	 * Prints all email address in group
	 * @param tab will be needed for printing  in nice format
	 */
	public void print(String tab) {
		
		System.out.print(tab);
		System.out.print(" (" + getName());
		System.out.println(", " + getEmailGroupAddress() + ")");
		
		Iterator<EmailAddress> iterator = this.createIterator();
		tab += "\t";
		
		while (iterator.hasNext()) {
			EmailAddress emailAdress = (EmailAddress)iterator.next();
			emailAdress.print(tab);
		}
	}
	
	public Iterator<EmailAddress> createIterator() {
		return new EmailAddressIterator(emailGroupAddresses.iterator());
	}
}
