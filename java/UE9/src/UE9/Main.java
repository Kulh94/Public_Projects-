package UE9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {
	
	//sort TreeSet
	public static void method2(String[] args) {
		TreeSet<Employee> s = new TreeSet<Employee>(
				(e1, e2) -> e1.getAge() -e2.getAge()
				);
				
	}
	
	
	//variable Arguments indem "..." angefügt wird
	public static void method1(String name, Employee ...employees) {
		//stram für employees 
		Stream.of(employees).filter((e) -> e.getAge() > 30).count();
	}

	public static void main(String[] args) {
		
		method1("Abeiter", new Employee("F1", "L1",20),
				new Employee("F2", "L2",31),
				new Employee("F3", "F3",45));
		
		String filename = "employee.ser";
		serialize(filename);
		deserialize(filename);

	}

	public static void serialize(String filename) {
		Employee e = new Employee("FirstName", "LastName", 30);
		try(ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(filename))){
			out.writeObject(e);
		}
		catch(IOException ex){
		ex.printStackTrace();
		}
		
	}
	
	public static void deserialize(String filename) {
		
		try(ObjectInputStream in = new ObjectInputStream (new FileInputStream (filename))){
			Employee e = new Employee("FirstName1", "LastName", 40);
			e=(Employee) in.readObject();
			System.out.println(e);
		}
		catch(Exception ex){
		ex.printStackTrace ();
		}
	}
	
}
