/**
 * 
 */
package printThread;

/**
 * @author dragos
 *
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print printService = new Print("[PrintService]");

		PrintThread myPT[] = {
				new PrintThread("1st"),
				new PrintThread("2nd")
		};
		
		myPT[0].setPrintService(printService);
		myPT[1].setPrintService(printService);
		
		
		
		myPT[1].start();
		myPT[0].start();
	}

}
