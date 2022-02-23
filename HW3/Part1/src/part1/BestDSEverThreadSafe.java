package part1;

/**
 * Implements the same interface with BestDSEver and hold an instance of it
 * @author murat
 */
public class BestDSEverThreadSafe implements Subject{
	
	/**
	 * Holds an instance of BestDSEver
	 */
	BestDSEver BS;
	
	/**
	 * Create a thread safe BestDSEver
	 */
	public BestDSEverThreadSafe() {
		BS = new BestDSEver();
	}
	
	/**
	 * Create a thread safe BestDSEver
	 */
	public BestDSEverThreadSafe(BestDSEver BS) {
		this.BS = BS;
	}
	
	
	/**
	 * Insert an element to BestDSEver
	 */
	@Override
	public synchronized void insert(Object o) {
		System.out.println("One thread is entered Insert");
		BS.insert(o);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("One thread is leaved Insert");
	}
	
	/**
	 * Remove an element to BestDSEver
	 */
	@Override
	public synchronized void remove(Object o) {
		System.out.println("One thread is entered Remove");
		BS.remove(o);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("One thread is leaved Remove");
	}

	/**
	 * Get an element to BestDSEver
	 */
	@Override
	public synchronized Object get(int index) {
		System.out.println("One thread is entered Get");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("One thread is leaved Get");
		return BS.get(index);
	}
}
