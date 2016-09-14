package threaddemo;

public class MyFirstThread extends Thread {
	
	private String name;
	
	public MyFirstThread(String name){
		this.name = name;
	}
	
	public void run() {
		// This is the code of my Thread
		System.out.println("Thread started ... " + this.name);
		System.out.println("Going to sleep for 5 sec");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Something wrong has happend?!?");
			e.printStackTrace();
		}
		System.out.println("Thread ends here!");
	}
}
