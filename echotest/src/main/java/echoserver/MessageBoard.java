package echoserver;

import java.util.ArrayList;

public class MessageBoard {
	public static ArrayList<EchoMultiServerThread> allClientConnections = new ArrayList<>();
	
	public static void broadcastMessage(String message, EchoMultiServerThread sender){
		for (EchoMultiServerThread echoMultiServerThread : allClientConnections) {
			if(sender != echoMultiServerThread)	echoMultiServerThread.sendMessage(message);
		}
		
	}
}
