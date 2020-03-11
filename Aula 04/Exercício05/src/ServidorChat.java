import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.Map;
 
public class ServidorChat {
	
	public static void main(String args[]) throws Exception {
 
		int porta = 3000;
		int numConn = 1;
		
		LinkedHashMap <InetAddress, Integer> nodesIp = new LinkedHashMap<InetAddress, Integer>();
		
		DatagramSocket serverSocket = new DatagramSocket(porta);
 
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
 
		while (true) {
 
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			System.out.println("Esperando por datagrama UDP na porta " + porta);
			serverSocket.receive(receivePacket);
			System.out.print("Datagrama UDP [" + numConn + "] recebido...");
 
			String sentence = new String(receivePacket.getData());
			System.out.println(sentence);
			
			if (!nodesIp.containsKey(receivePacket.getAddress()))
            	nodesIp.put(receivePacket.getAddress(), receivePacket.getPort());
            else
            	if (!nodesIp.get(receivePacket.getAddress()).equals(receivePacket.getPort()))
            		nodesIp.replace(receivePacket.getAddress(), receivePacket.getPort());
			
			for (Map.Entry<InetAddress, Integer> node : nodesIp.entrySet()) {
            	InetAddress ip = node.getKey();
            	if (ip.equals(receivePacket.getAddress())) {
            		Integer portaCliente = node.getValue();
                	
            		String texto = new String(receivePacket.getData(), 0,
                            receivePacket.getLength() );
            		texto = ip +": " + texto;
            		byte[] mensagem = texto.getBytes();
            		
            		DatagramPacket sendPacket =
                            new DatagramPacket( mensagem,
                                                texto.length(),
                                                ip,
                                                portaCliente
                                                 );
            			serverSocket.send( sendPacket );
            		
            	}
            }
			System.out.println("OK\n");
		}
	}
}

