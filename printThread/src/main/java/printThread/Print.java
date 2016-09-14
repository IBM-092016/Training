/**
 * 
 */
package printThread;

/**
 * @author dragos
 *
 */
public class Print {
	
	private String instanceName;
	
	public Print(String name){
		this.instanceName = name;
	}
	
	public synchronized void print(String threadName){
		System.out.println("Printer name: " + this.instanceName);
		System.out.println("Printing for " + threadName);
		for(int i = 5; i > 0; i--){
			System.out.print(i + " > ");
		}
		System.out.println("");
		System.out.println("Finished printing for " + threadName);
	}

}
