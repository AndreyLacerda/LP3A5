
public class PrintWord implements Runnable{
	
	String word;
	long ms;

	public PrintWord(String word, long ms) {
		this.word = word;
		this.ms = ms;
	}
	
	
	@Override 
	public void run() {
		try {
			int i = 1;
			while(true) {
				System.out.println(word + " " + i);
				i += 1;
				Thread.sleep(ms);
			}
		} catch(InterruptedException e) {
			System.out.println("\n" + Thread.currentThread().getName() + " interrupted.");
			System.out.println("INTERRUPTED flag: " + Thread.currentThread().isInterrupted());
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " IS DONE!");
	}

}