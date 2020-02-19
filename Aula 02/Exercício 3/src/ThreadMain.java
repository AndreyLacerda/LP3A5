
public class ThreadMain {
	
	public static void main(String args[]) {
		Runnable runnable = new CalculadoraRaizes();
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
}
