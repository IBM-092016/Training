package echoclient;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientReader extends Thread {
	
	public long sleepDuration = 500;
	public boolean running = true;
	private DataInputStream dis ;
	
	public void run(){
		while(running){
            try {
    			//Print the message received from server
				if (dis.available()>0) 	System.out.println(dis.readUTF());
				//Sleep for 500ms, this interval can be customized 
				Thread.sleep(sleepDuration);
			} catch (IOException | InterruptedException  e) {
				e.printStackTrace();
			}
		}
	}

	public void setDataInputStream(DataInputStream in) {
		this.dis = in;
	}

}
