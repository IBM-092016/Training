package behavioral.command;

public class RemoteControl {
	private final RemoteControlButton mOnButton;
	private final RemoteControlButton mOffButton;
	
	public RemoteControl(RemoteControlButton pOnButton,RemoteControlButton pOffButton) {
		mOffButton = pOffButton;
		mOnButton = pOnButton;
	}
	
	public void pressOn() {
		mOnButton.press();
	}
	
	public void pressOff() {
		mOffButton.press();
	}
}
