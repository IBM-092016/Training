package creational.factory;

public class FactoryClient {
	public static void main(String args[]) {
		System.out.println(MammalsFactory.getMammalObject("Cat").doWalking());
	}
}