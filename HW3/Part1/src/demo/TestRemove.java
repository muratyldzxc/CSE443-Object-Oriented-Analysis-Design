package demo;

import part1.BestDSEverThreadSafe;

/**
 * Removes element from given structure
 * @author murat
 */
public class TestRemove implements Runnable{

	int threadNum;
	BestDSEverThreadSafe BestDSTSafe;
	
	public TestRemove(BestDSEverThreadSafe BestDSTSafe, int threadNum) {
		this.threadNum = threadNum;
		this.BestDSTSafe = BestDSTSafe;
	}
	
	@Override
	public void run() {
		System.out.println("Thread " + threadNum + " try to removes");
		BestDSTSafe.remove((threadNum-5)*5);
		
	}
}
