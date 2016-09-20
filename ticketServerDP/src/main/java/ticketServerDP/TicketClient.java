package ticketServerDP;

import java.util.concurrent.BlockingQueue;

public class TicketClient implements Runnable {

	//Producer-Consumer shared Queue 
	private BlockingQueue<Integer> queue;
		
	public TicketClient(BlockingQueue<Integer> q){
		this.queue = q;
	}
	
	//Client part may get a ticket 1..n or 0 if no more tickets are available
	public void run() {
		try {
			//System.out.println("Client started");
			int mySeatNumber = queue.take();
			if (mySeatNumber > 0){
				System.out.println("My place is: " + mySeatNumber);
			}else{
				System.out.println("Sold out :(");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
