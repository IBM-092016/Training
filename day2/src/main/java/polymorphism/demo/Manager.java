package polymorphism.demo;

class Manager extends Employee {
	public Manager(String empName, String empId, String empDept, String empDesignation, double s, int year, int month,
			int day) {
		super(empName, empId, empDept, empDesignation, s, year, month, day);

	}

	public String getProfile(boolean isMGR) {
		// this getProfile() will override the one defined for Employee
//		System.out.println("Emp Name:" + empName);
//		System.out.println("Emp Id:" + empId);
//		System.out.println("Emp Designation:" + empDesignation);
	System.out.println("Is this employee a Manager?");
		// ..........
		isManager = "yes";
		return isManager;
	}
}
