package encapsulation.demo;

public class EncapsulationDemoMain {
	public static void main(String[] args) {
		User user1 = new User("Raj", "JavaGeeks", "myemail", "Rajasekhar", "Attmuri@ibm.com");
		System.out.println("User: " + user1.toString() + "\n");
		
		user1.setUsername("ABH");
		System.out.println("My new username is: " + user1.getUsername() + "\n");
		System.out.println("My password is: " + user1.getPassword());
		System.out.println("I am about to change my password...\n");
		
		user1.setPassword("IBM");
		System.out.println("My new password is: " + user1.getPassword());
	}

}
