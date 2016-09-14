package freeandwait;

public class PrintWorker extends Thread {

	private FileResource fileR;
	private NetworkResource networkR;

	public PrintWorker(FileResource fr, NetworkResource nr) {
		this.fileR = fr;
		this.networkR = nr;
	}

	public void run() {
		String threadName = this.getName();
		while (true) {
			// Try to get file resource first
			synchronized(this.fileR){
				while(!this.fileR.getResource()){
					try {
						System.out.println(threadName + " waiting for File ...");
						this.fileR.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			System.out.println(threadName + " < File! >");

			// Try to get a Network resource
			boolean GotNetworkResource = false;
			GotNetworkResource = this.networkR.getResource();

			if (!GotNetworkResource) {
				// If Network resource is not available then
				// free File and wait for notification
				this.fileR.freeResource();
				System.out.println(threadName + " FREE");
				try {
					System.out.println(threadName + " SLEEP");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println(threadName + " (= File + Network! =)");
				System.out.println(threadName + " _oOOo_ printing 8~");
				try {
					Thread.sleep((long)Math.random()*1000+1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.networkR.freeResource();
				this.fileR.freeResource();
				System.out.println(threadName + " [> DONE! <]");
				return;
			}

		}
	}
}
