/**
 * 
 */
package streamExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dragos
 *
 */
public class StreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person> arrPersons = new ArrayList<Person>();
		
		arrPersons.add(new Person(Person.SEX.FEMALE , "Anne", "anne@hotmail.com", 32.5 ));
		arrPersons.add(new Person(Person.SEX.FEMALE , "Carmen", "carmen@gmail.com", 52.5 ));
		arrPersons.add(new Person(Person.SEX.MALE , "John", "john@hotmail.com", 22.0 ));
		arrPersons.add(new Person(Person.SEX.MALE , "Doe", "doe@gmail.com", 30.0 ));
		arrPersons.add(new Person(Person.SEX.FEMALE , "Marry", "marry@gmail.com", 15.5 ));
		
		//count the number of persons of FEMALE/MALE gender
		System.out.println("The number of MALE in our sample: " +
		arrPersons.stream()
				.filter(p -> p.gender == Person.SEX.MALE)
				.count());

		//find all persons that have a gmail account
		arrPersons.stream()
		.filter(p -> p.email.endsWith("@gmail.com"))
		.forEach(System.out::println);
		
		//group persons by gender
		Map< Person.SEX, List<Person> > groupByGender =
				arrPersons.stream()
				          .collect(Collectors.groupingBy(Person::getGender));
		
		System.out.println(groupByGender);
/*		
		System.out.println("==========================");
		int counter = 0;
		for (Person person : arrPersons) {
			counter = (person.gender == Person.SEX.MALE)? counter+1:counter;
		}
		System.out.println("The number of MALES is: " + counter);
*/
	}

}
