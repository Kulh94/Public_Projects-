package TEST5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.omg.CORBA.OMGVMCID;

import java.lang.AutoCloseable;


public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		
		
		
		EnumSet<Species> set1 = EnumSet.of(Species.BORG, Species.HUMAN);
		EnumSet<Species> set2 = EnumSet.of(Species.VULCAN, Species.HUMAN);
		EnumSet<Species> set3 = EnumSet.of(Species.HUMAN, Species.BETAZOID);
		EnumSet<Species> set4 = EnumSet.of(Species.HUMAN);
		EnumSet<Species> set5 = EnumSet.of(Species.KLINGON, Species.HUMAN);
		EnumSet<Species> set6 = EnumSet.of(Species.KLINGON);
		EnumSet<Species> set7 = EnumSet.of(Species.HUMAN);
		
		try {
		Commander bq = new Commander("Borg Queen",set1);
		Commander mrs = new Commander("Mr. Spock", set2);
		Commander dt = new Commander("Deanna Troi", set3);
		Member wc = new Member("Wesley Crusher", set4);
		Member bet = new Member("BElanna Torres", set5);
		Commander w = new Commander("Worf", set6);
		Member ar = new Member("Alexander Rozhenko", set7);
		
		final List<Member> l = new ArrayList<>();
		l.add(bq);
		l.add(mrs);
		l.add(dt);
		l.add(wc);
		l.add(bet);
		l.add(w);
		l.add(ar);
		
		l.forEach(tornike -> System.out.println(tornike));
		
		
		
		try (FileOutputStream fileOut = new FileOutputStream("stark-trek.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut)){
			out.writeObject(l);
			}
			catch(IOException i) { i.printStackTrace(); }
		

		
		
			List<Member> l2= new ArrayList<>();
		
		try (FileInputStream fileIn = new FileInputStream("stark-trek.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn)){
			l2 =  (List<Member>) in.readObject();
			}catch(IOException i) {
			i.printStackTrace(); return;
			}catch(ClassNotFoundException c) {
			System.out.println("Member class not found");
			c.printStackTrace(); return;
			}
		
		
		
		for(Member s : l2) {
			System.out.println(s);
		}
		Map<Integer, List<Member>> m = l2.stream().collect(Collectors.groupingBy(s-> s.getSpecies().size()));
		m.forEach((k,v)->System.out.println(k + " = "+ v));
//		Map<Integer, List<Member>> m = new HashMap<>();
//		for(Member me : l2) {
//			 List<Member> result = new ArrayList<>(); 
//			 int key = me.getSpecies().size();
//			 
//			 if(m.containsKey(key))
//			 {
//				 result = m.get(key);
//				 result.add(me);
//				 m.put(key, result);
//			 }
//			 else {
//				 result.add(me);
//				 m.put(key, result);
//			 }
//			
//			
//		};
		

		for(Entry<Integer, List<Member>> s : m.entrySet()) {
			Collections.shuffle(s.getValue());
		}
	
		m.forEach((k,v)->System.out.println(k + " = "+ v));
		
		Comparator<Member> com = Comparator.comparing(Member::getReputation,(s1,s2)->{return s2.compareTo(s1);});
	
		

		for(Entry<Integer, List<Member>> ret : m.entrySet()) {
			Collections.sort(ret.getValue(),com);
		}
		
		m.forEach((k,v)->System.out.println(k + " = "+ v.toString().toLowerCase()));

		
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
