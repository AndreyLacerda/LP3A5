import java.util.ArrayList;

public class RaizQuadrada implements Runnable{
	
	@Override
	public void run() {
		this.raizQuadrada();
	}
	
	private void raizQuadrada() {
		ArrayList<Double> results = Repositorio.getArrayList();
		results.clear();
		for ( int i = 1 ; i < 100 ; i++) {
			if (i % 2 != 0) {
				results.add(Math.sqrt(i));
			}
		}
		Repositorio.setArrayList(results);
		Repositorio.printResult();
	}

}
