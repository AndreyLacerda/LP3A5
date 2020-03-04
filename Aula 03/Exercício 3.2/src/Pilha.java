
public class Pilha {
	
	private char pilha[] = {' ', ' ', ' ', ' ', ' ', ' '};
	private int cursor;
	
	public Pilha() {
		this.cursor = 0;
	}

	public synchronized char pop() {
		try {
			while (cursor == 0) {
				wait();
			}
			
			char retorno = this.pilha[this.cursor-1];
			this.cursor --;
			notifyAll();
			return retorno;
			
		} catch(InterruptedException e) {
			return ' ';
		}
	}
	
	public synchronized void push(char caractere) {
		try {
			while(this.cursor == 6) {
				wait();
			}
			this.pilha[this.cursor] = caractere;
			this.cursor ++;
			notifyAll();
		} catch(InterruptedException e) {
			
		}
		
	}

}
