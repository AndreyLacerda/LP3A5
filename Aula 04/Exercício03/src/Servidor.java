import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
 
public class Servidor {
	public static void main(String args[]) throws Exception {
 
		int porta = 3000;
		int numConn = 1;
		
		DatagramSocket serverSocket = new DatagramSocket(porta);
 
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		String sentence = "";
		while (true) {
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			System.out.println("Esperando por datagrama UDP na porta " + porta);
			serverSocket.receive(receivePacket);
			System.out.println("Datagrama UDP [" + numConn + "] recebido...");
 
			String letra = new String(receivePacket.getData(), 0, receivePacket.getLength());
			sentence = sentence + letra;
			
			if (letra.contains(";")) {
				
				int rows = ScripterSQL.rodarScript(sentence);
				
				InetAddress IPAddress = receivePacket.getAddress();
	 
				int port = receivePacket.getPort();
				
				String resposta;
				if (sentence.toUpperCase().contains("SELECT"))
					resposta = rows + " Linha(s) Encontrada(s).";
				else {
					if (rows != -1)
						resposta = rows + " Linha(s) Alterada(s).";
					else
						resposta = "Nenhuma linha foi alterada.";
				}
				
					sendData = resposta.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData,
							sendData.length, IPAddress, port);
					serverSocket.send(sendPacket);
					System.out.println("Enviando " + resposta + "...");

				System.out.println("OK\n");
				sentence = "";
			}
		}
	}
}

