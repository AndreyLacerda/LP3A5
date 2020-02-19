
public class ThreadMain {
	
	public static void main(String args[]) {
		Runnable runnable = new PrintWord("Texto", 200);
		Thread t1 = new Thread(runnable);
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {
			
		}
		t1.interrupt();
		System.out.println("\nThread " + Thread.currentThread().getName() + " IS DONE!");
	}
	
}
