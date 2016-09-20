package ticketServerDP;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TicketStore {

	public static void main(String[] args) {
		//Declare the common queue for Producer and Consumers
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(2);
		
		//Get a TicketServer
		TicketServer ts = TicketServer.getSingletonTicketServer(q);
		
		//Create a couple of Clients
		ArrayList<TicketClient> arrayClients = new ArrayList<TicketClient>();
		
		for(int i=0; i < 20; i++){
			arrayClients.add(new TicketClient(q));
		}
		
		for (TicketClient ticketClient : arrayClients) {
			new Thread(ticketClient).start();
		}
		
		//Start the TicketServer - the Producer
		new Thread(ts).start();
				

	}

}
