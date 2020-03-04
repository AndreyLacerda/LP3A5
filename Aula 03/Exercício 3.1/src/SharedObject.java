// Ao alterar o notifyAll() por notify(), o script passa a se comportar de forma errada. Além de demorar muito,
// não segue o padrão de consumir e resetar, o que gera as falhas. Isso deve ocorrer porque as threads não estão sendo notificadas
// corretamente ou ao mesmo tempo.
public class SharedObject {
	
	private volatile int value = -1;
	
	public boolean isSet() {
		return value != -1;
	}
	
	public synchronized boolean set(int v) {
		try {
			while(isSet()) {
				wait();
			}
			value = v;
			System.out.println(Thread.currentThread().getName() + ": PRODUCED: " + value);
			notify();
			return true;
		}catch(InterruptedException e) {
			return false;
		}
	}
	
	public synchronized boolean reset() {
		try {
			while(!isSet()) {
				wait();
			}
			System.out.println(Thread.currentThread().getName() + ": COSUMED: " + value);
			value = -1;
			notify();
			return true;
		}catch(InterruptedException e) {
			return false;
		}
	}

}
