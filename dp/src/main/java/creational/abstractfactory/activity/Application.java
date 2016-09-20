package creational.abstractfactory.activity;

public class Application {
	static class FactoryMaker {
		public GUIFactory makeFactory(String pOSName) {
			switch(pOSName) {
			case "WIN":
				return new WinFactory();
			case "OSX":
				return new OSXFactory();
			}
			throw new IllegalArgumentException("Unexpected OS name:" + pOSName);
		}
	}

	public static void main(String[] args) {
		FactoryMaker factoryMaker = new FactoryMaker();
		Button button1 = factoryMaker.makeFactory("OSX").createButton();
		button1.paint();
		Button button2 = factoryMaker.makeFactory("OSX").createButton();
		button2.paint();
	}

}
