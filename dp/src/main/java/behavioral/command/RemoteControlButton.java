package behavioral.command;

public class RemoteControlButton {
	private final Command mCommand;
	
	public RemoteControlButton(Command pCommand) {
		mCommand = pCommand;
	}
	
	public void press() {
		mCommand.execute();
	}
}
