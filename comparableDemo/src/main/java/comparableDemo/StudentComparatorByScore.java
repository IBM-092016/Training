/**
 * 
 */
package comparableDemo;

import java.util.Comparator;

/**
 * @author dragos
 *
 */
public class StudentComparatorByScore implements Comparator<Student> {

	public int compare(Student student1, Student student2) {
		return student1.score - student2.score;
	}
	
	public boolean equals(Student student){
		return true;
	}

}
