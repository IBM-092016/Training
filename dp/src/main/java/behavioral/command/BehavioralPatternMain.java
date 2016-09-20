package behavioral.command;

public class BehavioralPatternMain {
	public static void main(String[] args) {
		Light light = new Light();
		RemoteControl remote = new RemoteControl(new RemoteControlButton(new LightOnCommand(light)), 
				new RemoteControlButton(new LightOffCommand(light)));

		//light.checkStatus();

		remote.pressOn();
		light.checkStatus();
		remote.pressOff();
		light.checkStatus();
	}
}
