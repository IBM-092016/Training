/**
 * 
 */
package jdbcTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author dragos
 *
 */
public class Person {
	
	static ArrayList<Person> persons = new ArrayList<Person>();

	//Initialization SQL statement
	static String sqlReadStatement = "SELECT * FROM Person;";
	static String sqlCreateStatement = "INSERT INTO Person(name, email) VALUES (?, ?);";
	static String sqlUpdateStatement = "UPDATE Person SET name=?, email=? WHERE id > ?;";
	static String sqlDeleteStatement = "DELETE FROM Person WHERE name = ?;";

	private String name;
	private String email;
	private int id;
	
	public Person(ResultSet rs){
		//READ
		try {
			this.email = rs.getString("email");
			this.name = rs.getString("name");
			this.id = rs.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Person.persons.add(this);
	}
	
	public Person(String name, String email){
		//CREATE
		this.name = name;
		this.email = email;
		Person.persons.add(this);
	}
	
	
	public String toString(){
		return "Name: " + this.name + ", email: " + this.email
		+ ", [ID = " + this.id + " ]";
	}
	
	
	public static void update(String name, String email, int id ){
		for (Person person : persons) {
			if(person.id > id){
				person.email = email;
				person.name = name;
			}
		}
	}
}
