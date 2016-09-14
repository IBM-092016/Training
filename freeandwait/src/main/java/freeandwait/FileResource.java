package freeandwait;

public class FileResource {
	public final static int QUANTITY = 3;

	public static int resourceCount;
	
	public FileResource(){
		FileResource.resourceCount = FileResource.QUANTITY;
	}
	
	public synchronized boolean getResource(){
		if (resourceCount == 0) return false;
		
		resourceCount = resourceCount - 1;
		return true;
	}
	
	public synchronized void freeResource(){
		resourceCount++;
		this.notifyAll();
	}
	
}
