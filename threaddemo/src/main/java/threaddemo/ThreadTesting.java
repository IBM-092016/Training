/**
 * 
 */
package threaddemo;

/**
 * @author dragos
 *
 */
public class ThreadTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyFirstThread myFT [] = {
				new MyFirstThread("Dragos"), 
				new MyFirstThread("Constantin")
		};
		
		MyFirstRunnable myFR[] = {
				new MyFirstRunnable("Run - 1"),
				new MyFirstRunnable("Run - 2"),
				new MyFirstRunnable("Run - 3")
		};
		Thread threadForRunnables[] = {
				new Thread(myFR[0]),
				new Thread(myFR[1]),
				new Thread(myFR[2])
		};
		
		threadForRunnables[0].start();
		threadForRunnables[1].start();

		myFT[1].start();
		
		threadForRunnables[2].start();

		myFT[0].start();
	}

}
