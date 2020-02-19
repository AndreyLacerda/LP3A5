
public class ThreadMain {
	
	public static void main(String args[]) {
		Runnable r1 = new PrintWord("Txt", 200);
		Runnable r2 = new PrintWord("Text", 500);
		Runnable r3 = new PrintWord("téacs", 1000);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(5000);
			t1.interrupt();
			Thread.sleep(5000);
			t2.interrupt();
			Thread.sleep(5000);
			t3.interrupt();
		} catch (InterruptedException ignored) {
			
		}
		System.out.println("\nThread " + Thread.currentThread().getName() + " IS DONE!");
	}
	
}
