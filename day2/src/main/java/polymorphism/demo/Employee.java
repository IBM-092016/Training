package polymorphism.demo;

class Employee {
	String empName;
	String empId;
	String empDept;
	String empDesignation;
	double salary;
	int joinYear;
	int joinMonth;
	int joinDay;
	String isManager;

	public Employee(String empName, String empId, String empDept, String empDesignation, double s, int year, int month,
			int day) {
		this.empName = empName;
		this.empId = empId;
		this.empDept = empDept;
		this.empDesignation = empDesignation;
		this.salary = s;
		this.joinYear = year;
		this.joinMonth = month;
		this.joinDay = day;
	}

	String getProfile() {
//		System.out.println("Emp Name:" + empName);
//		System.out.println("Emp Id:" + empId);
//		System.out.println("Emp Designation:" + empDesignation);
		System.out.println("Is this employee a Manager?");
		// ..........
		isManager = "No";
		return isManager;
	}
}