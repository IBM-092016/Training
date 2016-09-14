package printThread;

public class PrintThread extends Thread {

	private Print printService;
	
	public PrintThread(String string) {
		super(string);
	}

	public void setPrintService(Print ps){
		this.printService = ps;
	}
	
	public void run(){
		printService.print(this.getName());
	}
}
