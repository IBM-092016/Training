package creational.abstractfactory.activity;

public class WinFactory implements GUIFactory {

	@Override
	public Button createButton() {
		return new WinButton();
	}

}
