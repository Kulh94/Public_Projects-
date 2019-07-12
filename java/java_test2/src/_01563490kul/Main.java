package _01563490kul;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;







public class Main {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		
		EnumSet<Species> set1= EnumSet.of(Species.BORG, Species.HUMAN);
		EnumSet<Species> set2= EnumSet.of(Species.VULCAN, Species.HUMAN);
		EnumSet<Species> set3= EnumSet.of(Species.HUMAN, Species.BETAZOID);
		EnumSet<Species> set4= EnumSet.of( Species.HUMAN);
		EnumSet<Species> set5= EnumSet.of(Species.KILNGON, Species.HUMAN);
		EnumSet<Species> set6= EnumSet.of(Species.KILNGON);
		EnumSet<Species> set7= EnumSet.of( Species.HUMAN);
		
		Commander borgqueen= new Commander("Borg Queen",set1);
		Commander mrspock= new Commander("Mr. Spock",set2);
		Commander deannatori= new Commander("Deanna Troi",set3);
		Member wesleycrusher= new Member("Wesley Crusher",set4);
		Member belannatorres= new Commander("BElanna Torres",set5);
		Commander worf= new Commander("Worf",set6);
		Member alexanderrozhenko= new Member("Alexander Rozhenko",set7);
		
		List<Member> l = new ArrayList<>();
		l.add(borgqueen);
		l.add(mrspock);
		l.add(deannatori);
		l.add(wesleycrusher);
		l.add(belannatorres);
		l.add(worf);
		l.add(alexanderrozhenko);
		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("stark-trek.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(l);
			out.close();
			fileOut.close();
			}
			catch(IOException i) { i.printStackTrace(); }
		
		try {
			FileInputStream fileIn = new FileInputStream("stark-trek.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			l =  (List<Member>) in.readObject();
			in.close();
			fileIn.close();
			}catch(IOException i) {
			i.printStackTrace(); return;
			}catch(ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace(); return;
			}
		
		for(Member s : l) {
			System.out.println(s);
		}
		
		
		Map<Integer,List<Member>> m = new HashMap<>();
		for(Member s : l) {
		m.put(s.getSpecies().size(), (List<Member>) s);
		}
		
		Collections.shuffle((List<?>) m.entrySet());
		
		
		System.out.println(m);
		
		
		
		

	}

}
