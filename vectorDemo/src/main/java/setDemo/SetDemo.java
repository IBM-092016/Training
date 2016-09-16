/**
 * 
 */
package setDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author dragos
 *
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {5, 2, 9, 4, 1};
		
		System.out.print("Original array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		Set <Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			hs.add(new Integer(a[i]));
		}
		System.out.println("HashSet: " + hs);
		
		Set <Integer> lhs = new LinkedHashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			lhs.add(new Integer(a[i]));
		}
		System.out.println("LinkedHashSet: " + lhs);
		
		Set <Integer> ts = new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			ts.add(new Integer(a[i]));
		}
		System.out.println("TreeSet: " + ts);
		
		
		
		
		
	}

}
