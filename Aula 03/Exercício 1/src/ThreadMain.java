public class ThreadMain {
	
	public static void main(String args[]) {
		Runnable runnableQuadrado = new RaizQuadrada();
		Thread threadQuadrado = new Thread(runnableQuadrado);
		Runnable runnableCubico = new RaizCubica();
		Thread threadCubico = new Thread(runnableCubico);
		threadQuadrado.start();
		threadCubico.start();
	}
}