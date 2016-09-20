package creational;

class SingletonClass {
	private static SingletonClass singletonObject;

	private SingletonClass() {
		// Optional Code
	}

	public static synchronized SingletonClass getSingletonObject() {
		if (singletonObject == null) {
			singletonObject = new SingletonClass();
		}
		return singletonObject;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}