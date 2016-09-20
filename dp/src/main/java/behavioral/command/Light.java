package behavioral.command;

public class Light {
	private boolean mOn;
	
	public void switchOn() {
		mOn = true;
	}
	
	public void switchOff() {
		mOn = false;
	}
	
	public void checkStatus() {
		System.out.println("Light is " + (mOn ? "ON" : "OFF"));
	}
}
