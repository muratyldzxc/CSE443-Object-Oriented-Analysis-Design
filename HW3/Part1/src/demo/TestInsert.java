package demo;

import part1.BestDSEverThreadSafe;

/**
 * Inserts element to given structure
 * @author murat
 */
public class TestInsert implements Runnable{

	int threadNum;
	BestDSEverThreadSafe BestDSTSafe;
	
	public TestInsert(BestDSEverThreadSafe BestDSTSafe, int threadNum) {
		this.threadNum = threadNum;
		this.BestDSTSafe = BestDSTSafe;
	}
	
	@Override
	public void run() {
		System.out.println("Thread " + threadNum + " try to inserts");
		BestDSTSafe.insert(threadNum*5);
		
	}
}
