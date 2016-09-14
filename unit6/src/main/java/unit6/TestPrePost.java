/**
 * 
 */
package unit6;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author dragos
 *
 */
public class TestPrePost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		int i = 6;
		i++; // i = 7
		System.out.println("i after post - stand alone: " + i);
		++i; // i = 8
		System.out.println("i before pre: " + i);
		System.out.println("i pre: " + ++i); // i = 9
		System.out.println("i post: " + i++); // i = 10
		System.out.println("i after post: " + i);
		
		
		int a = 5, b =3;
		int c = a++ + --b;
		System.out.println("a is: " + a + " and b is: "+ b);
		System.out.println("c is: " + c);
*/
		int x = 0, y = 0;
		for(int z = 0 ; z<5; z++){
			System.out.println("z = " + z);
			System.out.println("x = " + x + " and y = " + y);

			if ((++x > 2) && (++y > 2)){
				x++;
			}
		}
		System.out.println("x = " + x + " and y = " + y);
	}

}
