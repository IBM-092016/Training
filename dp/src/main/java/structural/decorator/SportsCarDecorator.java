package structural.decorator;

public class SportsCarDecorator extends CarDecorator {
	public SportsCarDecorator(Car pCar) {
		super(pCar);
	}

	@Override
	public void assemble() {
		mCar.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}
