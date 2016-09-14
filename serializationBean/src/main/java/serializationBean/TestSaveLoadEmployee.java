/**
 * 
 */
package serializationBean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author dragos
 *
 */
public class TestSaveLoadEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*
		Employee me = new Employee();
		
		me.name = "Dragos";
		me.jobPosition = "Trainer";
		me.setId(22);
		
		try {
			FileOutputStream fos = new FileOutputStream("emp.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(me);
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee saved to disk!");
*/
		//Read the data form file
		
		Employee me = null;
		try {
			FileInputStream fis = new FileInputStream("emp.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			me = (Employee) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.exit(0);
			//e.printStackTrace();
		}
		System.out.println("My employee data is: " + me.name + ", " 
		                                           + me.getId() + ", " 
				                                   + me.jobPosition + ".");
		
		
	}

}
