package threaddemo;

public class MyFirstRunnable implements Runnable {
	
	private String name;
	
	public MyFirstRunnable(String name){
		this.name = name;
	}

	public void run() {
		// This is the code of my Thread
		System.out.println("Runnable started ... " + this.name);
		System.out.println("Going to sleep for 3 sec");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Something wrong has happend?!?");
			e.printStackTrace();
		}
		System.out.println("Runnable ends here!");

	}

}
