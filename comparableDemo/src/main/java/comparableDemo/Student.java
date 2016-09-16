/**
 * 
 */
package comparableDemo;

/**
 * @author dragos
 * @param <T>
 *
 */
public class Student implements Comparable<Student> {

	public int score;
	public String name;
	
	public Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public int compareTo(Student otherStudent) {
		return  otherStudent.name.compareTo(this.name);
				//this.name.compareTo(otherStudent.name);
		//return  otherStudent.score - this.score;
	}

}
