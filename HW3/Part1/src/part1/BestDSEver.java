package part1;

import java.util.ArrayList;

/**
 * Provided by someone else
 * @author murat
 */
public class BestDSEver implements Subject{
	
	ArrayList<Object> structure;
	
	public BestDSEver() {
		structure = new ArrayList<Object>();
	}

	@Override
	public void insert(Object o) {
		structure.add(o);
	}

	@Override
	public void remove(Object o) {
		structure.remove(o);
	}

	@Override
	public Object get(int index) {
		return structure.get(index);
	}

}
