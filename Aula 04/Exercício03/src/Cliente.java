import java.io.*;
import java.net.*;
 
public class Cliente {
	public static void main(String args[]) throws Exception {
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
					System.in));
	 
			DatagramSocket clientSocket = new DatagramSocket();
	 
			String servidor = "localhost";
			int porta = 3000;
	 
			InetAddress IPAddress = InetAddress.getByName(servidor);
		while(true) {
			byte[] sendData;
			byte[] receiveData = new byte[1024];
	 
			String sentence = inFromUser.readLine();
			char[] letras = sentence.toCharArray();
			for (int i = 0; i < letras.length; i++) {
				sendData = Character.toString(letras[i]).getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, porta);
				clientSocket.send(sendPacket);
			}

			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
	 
			clientSocket.receive(receivePacket);
	 
			String modifiedSentence = new String(receivePacket.getData());
	 
			System.out.println(modifiedSentence);
		}
	}
}