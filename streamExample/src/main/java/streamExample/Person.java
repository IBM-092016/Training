/**
 * 
 */
package streamExample;

/**
 * @author dragos
 *
 */
public class Person {
	public enum SEX{
		MALE, FEMALE
	}
	
	
	SEX gender;
	String name;
	String email;
	double age;
	
	public Person(SEX g, String n, String e, double a){
		this.gender = g;
		this.name = n;
		this.email = e;
		this.age = a;
	}
	
	
	public SEX getGender(){
		return this.gender;
	}
	
	public int addOne(int i){
		return i;
	}
	
	@Override
	public String toString(){
		return "Name: " + name;
	}
	

}
