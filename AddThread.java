import java.util.Random;

public class AddThread implements Runnable {
	
	int[] numArray;
	int threadBurden;
	int threadSum = 0;
	Thread myThread;
	
	public AddThread(int tSize, int tCount) {
		threadBurden = tSize / tCount;		// Determines thread burden by dividing total size by current thread count
		numArray = new int[threadBurden];	// Allocates space for the array based on burden
		myThread = new Thread(this);
		myThread.start();
	}
	
	public void join() {
		try {
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {

		for (int i = 0; i < threadBurden; i++) {
			numArray[i] = (new Random().nextInt(9)) + 1;	// Adds random number between 1 and 10 to array
			threadSum = threadSum + numArray[i];			// Adds array numbers to total sum
		}
	}
	
	public int getValue() {
        return threadSum;
    }
}
