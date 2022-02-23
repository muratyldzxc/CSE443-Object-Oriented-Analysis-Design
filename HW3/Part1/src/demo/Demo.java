package demo;

import part1.BestDSEver;
import part1.BestDSEverThreadSafe;

public class Demo {

	public static void main(String[] args) {
		
		BestDSEver BestDS = new BestDSEver();
		
		BestDSEverThreadSafe BestDSTSafe = new BestDSEverThreadSafe(BestDS);
		
		Thread threads[] = new Thread[10];
		
		for(int i=0; i<5; i++) {
			threads[i] = new Thread(new TestInsert(BestDSTSafe, i));
		}
		
		for(int i=5; i<10; i++) {
			threads[i] = new Thread(new TestRemove(BestDSTSafe, i));
		}
		
		for(int i=0; i<10; i++) {
			threads[i].start();
		}
		
		for(int i=0; i<10; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
