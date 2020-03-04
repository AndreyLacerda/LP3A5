import java.util.ArrayList;

public class Repositorio {
	
	private static ArrayList<Double> results = new ArrayList<Double>();
	
	public synchronized static ArrayList<Double> getArrayList(){
		return results;
	}
	
	public synchronized static void setArrayList(ArrayList<Double> resultados){
		
		results = resultados;
	}
	
	public synchronized static void printResult() {
		System.err.println("Raízes");
		ArrayList<Double> results = getArrayList();
		for (int i = 0 ; i < results.size() ; i++) {
			System.out.println(results.get(i));
			try {
				Thread.sleep(50);
			} catch (InterruptedException ignored) {
				
			}
			
		}
	}

}
