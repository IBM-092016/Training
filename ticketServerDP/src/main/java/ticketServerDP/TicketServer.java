/**
 * 
 */
package ticketServerDP;

import java.util.concurrent.BlockingQueue;
/**
 * @author dragos
 *
 */
public class TicketServer implements Runnable{
	
	//Signleton Desing Pattern
	private static TicketServer myServer;
	
	//Number of seats
	private static int numberOfSeats = 10;
	
	//Producer-Consumer shared Queue 
	private BlockingQueue<Integer> queue;
	
	private TicketServer(BlockingQueue<Integer> q){
		this.queue = q;
	}

	private TicketServer(){
		
	}
	
	//Get a single unique instance of TicketServer
	public static synchronized TicketServer getSingletonTicketServer(BlockingQueue<Integer> q) {
		if (myServer == null) {
			myServer = new TicketServer(q);
		}
		return myServer;
	}
	
	//Deny default Java cloning
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	
	//Producer loop
	public void run() {
			try {
				//System.out.println("Server started");
				//Put all 10 tickets on the market -> Queue
				for(int i = 1; i <= numberOfSeats; i++){
					queue.put(i);
				}
				//all other clients will get 0
				while(true){
					queue.put(0);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
