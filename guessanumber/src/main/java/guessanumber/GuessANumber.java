/**
 * 
 */
package guessanumber;

import java.util.Random;

/**
 * @author dragos
 *
 */
public class GuessANumber {
	
	private int hiddenNumber;
	
	public GuessANumber(){
		Random rn = new Random();
		this.hiddenNumber = rn.nextInt(20);
	}
	
	public GuessANumber(int upperLimit){
		Random rn = new Random();
		this.hiddenNumber = rn.nextInt(upperLimit);
	}
	
	public int getHiddenNumber(){
		return this.hiddenNumber;
	}

}
