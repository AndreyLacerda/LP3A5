
public class Consumidor implements Runnable{
	
	private Pilha pilha;
	
	public Consumidor(Pilha pilha) {
		this.pilha = pilha;
	}

	@Override
	public void run() {
		
		while(true) 
			System.out.println( pilha.pop());
		
	}

}
