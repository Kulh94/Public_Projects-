//package TEST5NT;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.EnumSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.stream.Collectors;
//
//public class Main {
//
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) {
//	
//		Ruler js =new Ruler("Jon Snow", EnumSet.of(FamilyLineage.STARK));
//		FamilyMember jof = new FamilyMember("Joffrey", EnumSet.of(FamilyLineage.BARATHEON, FamilyLineage.LANNISTER, FamilyLineage.STARK));
//		FamilyMember ty = new FamilyMember("Tywin", EnumSet.of(FamilyLineage.LANNISTER, FamilyLineage.BARATHEON));
//		FamilyMember jh = new FamilyMember("Jorah", EnumSet.of(FamilyLineage.STARK, FamilyLineage.TARAGARYEN));
//		Ruler ct = new Ruler("Tormund", EnumSet.of(FamilyLineage.TYRELL, FamilyLineage.BARATHEON));
//		Ruler tyr = new Ruler("Tyrion", EnumSet.of(FamilyLineage.LANNISTER, FamilyLineage.TARAGARYEN));
//		Ruler cat = new Ruler("Catelyn", EnumSet.of(FamilyLineage.STARK, FamilyLineage.TARAGARYEN, FamilyLineage.LANNISTER));
//		
//		final List<FamilyMember> l = new ArrayList<>();
//		l.add(js);
//		l.add(jof);
//		l.add(ty);
//		l.add(jh);
//		l.add(ct);
//		l.add(tyr);
//		l.add(cat);
//		
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game-of-thrones.ser"))){
//				out.writeObject(l);
//				
//		}catch(IOException ex) {
//			ex.printStackTrace();
//		}
//		
//		List<FamilyMember> l2 = new ArrayList<>();
//		
//		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("game-of-thrones.ser"))){
//			l2 = (List<FamilyMember>) in.readObject();
//		}catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		
//		l2.forEach(out-> System.out.println(out));
//		
//		Map<Character, List<FamilyMember>> m = l2.stream().collect(Collectors.groupingBy(wert->wert.getName().charAt(0)));
//		
//		m.forEach((k,v)->System.out.println(k +"="+ v));
//		
//		for(Entry<Character, List<FamilyMember>> e : m.entrySet()) {
//			Collections.shuffle(e.getValue());
//		}
//		System.out.println("");
//		
//		m.forEach((k,v)->System.out.println(k +"="+ v));
//		
//		System.out.println("");
//		
//       Comparator<FamilyMember> comp = Comparator.comparing(FamilyMember::getPrestige, (a,b)->{return a.compareTo(b);});
//       
//       for(Entry<Character, List<FamilyMember>> e : m.entrySet()) {
//			Collections.sort(e.getValue(),comp);
//		}
//       
//       System.out.println("");
//		
//		m.forEach((k,v)->System.out.println(k.toString().toUpperCase() +"="+ v.toString().toUpperCase()));
//       
//	}
//
//
//}
