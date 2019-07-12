package Test5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import UE9.Employee;

public class Main {

	public static void main(String[] args) {
		
		EnumSet<Typ> set1 = EnumSet.of(Typ.HEILUNG, Typ.SCHUTZ);
		EnumSet<Typ> set2 = EnumSet.of(Typ.HEX, Typ.HEILUNG);
		EnumSet<Typ> set3 = EnumSet.of(Typ.SCHUTZ);
		
		
		Magier hp = new Magier("Harry Potter", set1);
		Magier hg = new Magier("Hermione Granger", set2);
		Magier rw = new Magier("Ron Weasly", set3);
		
		System.out.println(hp);
		System.out.println(hg);
		System.out.println(rw);

	//Map<Zauberer, double> map = new HashMap<>();
		
		Map<Zauberer, Double> m = new HashMap<>();
		m.put(hp, (double) (1/hp.getAnsehen()));
		m.put(hg, (double) (1/hg.getAnsehen()));
		m.put(rw, (double) (1/rw.getAnsehen()));
		
		String filename= "zauberer.map";
		serialize(filename);
		deserialize(filename);
		
	
		
		
		
		
	}
	public static void serialize(String filename) {
		
		try(ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(filename))){
			out.writeObject(m);
		}
		catch(IOException ex){
		ex.printStackTrace();
		}
		
	}
	
	public static void deserialize(String filename) {
		
		try(ObjectInputStream in = new ObjectInputStream (new FileInputStream (filename))){
			e=(Employee) in.readObject();
			System.out.println(e);
		}
		catch(Exception ex){
		ex.printStackTrace ();
		}
	}
	
	
}
