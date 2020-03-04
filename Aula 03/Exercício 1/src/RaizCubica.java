import java.util.ArrayList;

public class RaizCubica implements Runnable{
	
	@Override
	public void run() {
		this.raizCubica();
	}
	
	private void raizCubica() {
		ArrayList<Double> results = Repositorio.getArrayList();
		results.clear();
		for ( int i = 2 ; i < 1001 ; i++) {
			if (i % 2 == 0) {
				results.add(Math.cbrt(i));
			}
		}
		Repositorio.setArrayList(results);
		Repositorio.printResult();
	}
}
