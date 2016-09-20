package creational.abstractfactory;

abstract class Day {
	final boolean mRainy;
	final boolean mCold;

	protected Day(boolean pIsRainy, boolean pIsCold) {
		mRainy = pIsRainy;
		mCold = pIsCold;
	} 

	public boolean isRainy() {
		return mRainy;
	}

	public boolean isCold() {
		return mCold;
	}

	@Override
	public String toString() {
		return "class:" + this.getClass().getSimpleName() + " [mRainy=" + mRainy + ", mCold=" + mCold + "]";
	}
}

class ColdRainyDay extends Day {
	ColdRainyDay() {
		super(true, true);
	}
}

class ColdDay extends Day {
	ColdDay() {
		super(false, true);
	}
}

class RainyDay extends Day {
	RainyDay() {
		super(true, true);
	}
}
 
class RegularDay extends Day {
	RegularDay() {
		super(false, false);
	}
}

