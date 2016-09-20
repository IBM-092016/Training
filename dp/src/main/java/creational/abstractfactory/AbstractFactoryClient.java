package creational.abstractfactory;

//Factory creator , an indirect way of instantiating the factories
class FactoryMaker {
	static AbstractDayFactory getFactory() {
		double rnd = Math.random();
		if(rnd <= 0.25) {
			return new ColdRainyDayFactory();
		} else if(rnd <= 0.5) {
			return new RainyDayFactory();
		} else if(rnd <= 0.75) {
			return new ColdDayFactory();
		} else {
			return new DayFactory();
		}
	}
}

// Client
public class AbstractFactoryClient {
	public static void main(String args[]) {
		for(int i=0;i <= 10;i++) {
			System.out.println("Generate day " + i + ":" + FactoryMaker.getFactory().createDay());
		}
	}
}