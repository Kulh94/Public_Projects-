package TEST5NT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Ruler r1 = new  Ruler("Jon Snow", EnumSet.of(FamilyLineage.STARK));
		FamilyMember m1 = new FamilyMember("Joffrey", EnumSet.of(FamilyLineage.BARATHEON, FamilyLineage.LANNISTER, FamilyLineage.STARK));
		FamilyMember m2 = new FamilyMember("Tywin", EnumSet.of(FamilyLineage.LANNISTER, FamilyLineage.BARATHEON));
		FamilyMember m3 = new FamilyMember("Jorah", EnumSet.of(FamilyLineage.STARK, FamilyLineage.TARAGARYEN));
		Ruler r2 = new  Ruler("Tormund", EnumSet.of(FamilyLineage.TYRELL, FamilyLineage.BARATHEON));
		Ruler r3 = new  Ruler("Tyrion", EnumSet.of(FamilyLineage.LANNISTER, FamilyLineage.TARAGARYEN));
		Ruler r4 = new  Ruler("Catelyn", EnumSet.of(FamilyLineage. STARK, FamilyLineage.TARAGARYEN, FamilyLineage.LANNISTER));
		
		final List<FamilyMember> l = new ArrayList<>();
		l.add(r1);
		l.add(m1);
		l.add(m2);
		l.add(m3);
		l.add(r2);
		l.add(r3);
		l.add(r4);
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game-of-thornes.ser"))){
			out.writeObject(l);
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		List<FamilyMember> l2= new ArrayList<>();
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("game-of-thrones.ser"))){
			l2 = (List<FamilyMember>) in.readObject();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		l2.forEach(out->System.out.println(out));
		
		Map<Character, List<FamilyMember>> m = l2.stream().collect(Collectors.groupingBy(wert->wert.getName().charAt(0)));
		
		for(Entry<Character, List<FamilyMember>> map : m.entrySet()) {
			Collections.shuffle(map.getValue());
		}
		
		m.forEach((k,v)->System.out.println(k +"=" + v));
		
		Comparator<FamilyMember> comp= Comparator.comparing(FamilyMember::getPrestige, (a,b)->{return a.compareTo(b);});
		

		for(Entry<Character, List<FamilyMember>> map : m.entrySet()) {
			Collections.sort(map.getValue(), comp);
		}
		
		
		m.forEach((k,v)->System.out.println(k +"=" + v));
	}
	
		

}
