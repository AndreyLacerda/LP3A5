
public class Executor {
	
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		Runnable runnableConsumidor = new Consumidor(pilha);
		Thread threadConsumidor = new Thread(runnableConsumidor);
		Runnable runnableProdutor = new Produtor(pilha);
		Thread threadProdutor = new Thread(runnableProdutor);
		threadConsumidor.start();
		threadProdutor.start();
	}
	
}
