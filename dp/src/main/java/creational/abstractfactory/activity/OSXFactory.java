package creational.abstractfactory.activity;

public class OSXFactory implements GUIFactory {

	@Override
	public Button createButton() {
		return new OSXButton();
	}

}
