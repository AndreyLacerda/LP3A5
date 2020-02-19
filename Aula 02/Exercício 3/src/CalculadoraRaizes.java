import java.util.ArrayList;

public class CalculadoraRaizes implements Runnable{
	
	ArrayList<Double> results = new ArrayList<Double>();
	
	@Override
	public void run() {
		this.raizQuadrada();
		this.raizCubica();
	}
	
	private void raizQuadrada() {
		results.clear();
		for ( int i = 1 ; i < 1000 ; i++) {
			if (i % 2 != 0) {
				results.add(Math.sqrt(i));
			}
		}
		this.printResult();
	}
	
	private void raizCubica() {
		results.clear();
		for ( int i = 2 ; i < 1001 ; i++) {
			if (i % 2 == 0) {
				results.add(Math.cbrt(i));
			}
		}
		this.printResult();
	}
	
	private void printResult() {
		for (int i = 0 ; i < results.size() ; i++) {
			System.out.println(results.get(i));
			try {
				Thread.sleep(50);
			} catch (InterruptedException ignored) {
				
			}
			
		}
	}

}
