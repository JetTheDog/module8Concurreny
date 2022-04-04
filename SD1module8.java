public class SD1module8 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int totalSize = 200000000;
		int threadCount = 1;
		AddThread threadArray[] = new AddThread[threadCount];
		double grandTotal = 0;
		
		
		for (int i = 0; i < threadCount; i++) {
			threadArray[i] = new AddThread(totalSize, threadCount);	// Loop to create and start threads
			
		}
		
		System.out.println("Threads created, waiting\n");
		for (int i = 0; i < threadCount; i++) {				// Lets all threads finish before moving on
				threadArray[i].join();
		}
		
		for (int i = 0; i < threadCount; i++) {
			grandTotal = grandTotal + threadArray[i].getValue();	// Gets total sum from all threads
		}
		
		long endTime = System.nanoTime();
		double totalTime = (endTime - startTime) / 1000000000.0;
		System.out.println("The sum of " + totalSize + " random numbers is: " + grandTotal);
		System.out.println("Using " + threadCount + " threads took " + totalTime + " seconds.");
	}
}