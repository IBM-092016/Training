package behavioral.command;

public class LightOnCommand implements Command {
	private final Light mLight;
	
	public LightOnCommand(Light pLight) {
		mLight = pLight;
	}
	
	public void execute() {
		mLight.switchOn();
	}

}
