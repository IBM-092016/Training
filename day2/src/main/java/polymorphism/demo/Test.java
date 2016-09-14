package polymorphism.demo;

class Test {
	public static void main(String[] args) {
		Manager emp = new Manager("ABC", "1234", "ISD", "Employee", 10000, 2000, 10, 10);
		System.out.println(emp.getProfile());
		// if you would like to show the employee version of getProfile().
		// You can rename the function in Manager.java
	}
}
