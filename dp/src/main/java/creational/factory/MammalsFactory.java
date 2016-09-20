package creational.factory;

public class MammalsFactory {
	public static Mammals getMammalObject(String name) {
		if (name.equalsIgnoreCase("Cat")) {
			return new Cat();
		} else {
			return new Dog();
		}
	}
}