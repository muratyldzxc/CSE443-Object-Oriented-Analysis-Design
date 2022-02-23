package emailAddressBook;

import java.util.Iterator;
import java.util.Stack;

/**
 * This part taken from the book
 * @author murat
 */
public class EmailAddressIterator implements Iterator<EmailAddress>{
	Stack<Iterator<EmailAddress>> stack = new Stack<Iterator<EmailAddress>>();
	
	public EmailAddressIterator(Iterator<EmailAddress> iterator) {
		stack.push(iterator);
	}
	
	@Override
	public EmailAddress next() {
		if (hasNext()) {
			Iterator<EmailAddress> iterator = (Iterator<EmailAddress>) stack.peek();
			EmailAddress component = (EmailAddress) iterator.next();
			
			return component;
		} 
		else {
			return null;
		}
	}

	@Override
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} 
		else {
			Iterator<EmailAddress> iterator = (Iterator<EmailAddress>) stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} 
			else {
				return true;
			}
		}
	}

}
