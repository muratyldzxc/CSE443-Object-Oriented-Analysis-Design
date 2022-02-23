package emailAddressBook;

import java.util.Iterator;

/**
 * Defines an empty objects behaviours
 * @author murat
 */
public class NullIterator implements Iterator<EmailAddress>{

	
	/**
	 * Returns false
	 */
	@Override
	public boolean hasNext() {
		return false;
	}

	/**
	 * Returns null
	 */
	@Override
	public EmailAddress next() {
		return null;
	}

}
