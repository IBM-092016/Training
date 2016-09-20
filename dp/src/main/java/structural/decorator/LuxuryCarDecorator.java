package structural.decorator;

public class LuxuryCarDecorator extends CarDecorator {
	public LuxuryCarDecorator(Car pCar) {
		super(pCar);
	}

	@Override
	public void assemble() {
		mCar.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}
