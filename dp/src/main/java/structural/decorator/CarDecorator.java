package structural.decorator;

public class CarDecorator implements Car {
	protected Car mCar;

	public CarDecorator(Car pCar) {
		mCar = pCar;
	}

	@Override
	public void assemble() {
		mCar.assemble();
	}

}
