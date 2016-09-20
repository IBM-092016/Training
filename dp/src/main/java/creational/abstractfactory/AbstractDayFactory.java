package creational.abstractfactory;

abstract class AbstractDayFactory {
	abstract Day createDay();
}

class ColdRainyDayFactory extends AbstractDayFactory {
	Day createDay() {
		return new ColdRainyDay();
	}
}

class ColdDayFactory extends AbstractDayFactory {
	Day createDay() {
		return new ColdDay();
	}
}

class RainyDayFactory extends AbstractDayFactory {
	Day createDay() {
		return new RainyDay();
	}
}

class DayFactory extends AbstractDayFactory {
	Day createDay() {
		return new RegularDay();
	}
}

