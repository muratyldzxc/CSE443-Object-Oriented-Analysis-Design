package synchronizationBarrier;

/**
 * Barrier for threads to be waited or notified
 * @author murat
 */
public class MyBarrier {
	/**
	 * Number of threads to be notified
	 */
	int initialThreadCount;
	/**
	 * Number of threads to be waited
	 */
	int threadsAwait;

	/**
	 * Create a barrier with given parameter
	 * @param threadsAwait Number of threads to be operated
	 */
	public MyBarrier(int threadsAwait) {
        this.initialThreadCount = threadsAwait;
        this.threadsAwait = threadsAwait;   
	}
	
	
	/**
	 * Waits until all threads come, after all threads came it notify all threads
	 * @throws InterruptedException
	 */
	public synchronized void await() throws InterruptedException {
		threadsAwait--;

	    if(threadsAwait>0){
	    	this.wait();
	    }
	   else{	         
		   threadsAwait = initialThreadCount;
		   notifyAll(); 
	   }
	}
}
