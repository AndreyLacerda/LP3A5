
public class Produtor implements Runnable{
	
	private Pilha pilha;
	
	public Produtor(Pilha pilha) {
		this.pilha = pilha;
	}
	
	@Override
	public void run() {
		char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < 26; i++) {
			pilha.push(alfabeto[i]);
		}
		
	}
}
