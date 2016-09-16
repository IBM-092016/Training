/**
 * 
 */
package comparableDemo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author dragos
 *
 */
public class ComparableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TreeSet<Student> studentTreeSet= new TreeSet<Student>();
		StudentComparatorByScore scbs = new StudentComparatorByScore();
		
		TreeSet<Student> studentTreeSet= new TreeSet<Student>(scbs);
		
		studentTreeSet.add(new Student("Ann", 87));
		studentTreeSet.add(new Student("Bob", 83));
		studentTreeSet.add(new Student("Cat", 99));
		studentTreeSet.add(new Student("Dan", 25));
		studentTreeSet.add(new Student("Eve", 76));

		Iterator<Student> iteratorStudentTreeSet = studentTreeSet.iterator();
		
		while(iteratorStudentTreeSet.hasNext()){
			Student student = iteratorStudentTreeSet.next();
			System.out.println(student.name +  " has score: " +
					student.score);
		}
		
		
	}

}
