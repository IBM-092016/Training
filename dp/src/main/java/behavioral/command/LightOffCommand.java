package behavioral.command;

public class LightOffCommand implements Command {
	private final Light mLight;

	public LightOffCommand(Light pLight) {
		mLight = pLight;
	}

	public void execute() {
		mLight.switchOff();
	}

}
