/**
 * 
 */
package vectorDemo;

import java.util.Vector;

/**
 * @author dragos
 *
 */
public class VectorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(3, 2);
		System.out.println("Initial size: " + v.size());
		System.out.println("Initial capacity: " + v.capacity());
		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		System.out.println("Capacity after four additions: " + v.capacity());
	}

}
