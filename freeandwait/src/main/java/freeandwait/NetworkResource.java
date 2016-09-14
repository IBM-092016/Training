package freeandwait;

public class NetworkResource {

	public final static int QUANTITY = 1;

	private boolean ALLOCATED = false;
	
	public synchronized boolean getResource(){
		if(!ALLOCATED){
			ALLOCATED = true;
			return ALLOCATED;
		}
		return false;
	}
	
	public synchronized void freeResource(){
		ALLOCATED = false;
	}
	
}
