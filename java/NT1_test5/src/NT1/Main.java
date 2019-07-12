package NT1;

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

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try {
		Farm f1 = new Farm(null, EnumSet.of(Animal.CAT, Animal.DOG, Animal.DUCK));
		FeedLot f2 = new FeedLot("Cattle Lot C42", EnumSet.of(Animal.CATTLE, Animal.DOG));
		Farm f3 = new Farm("Puder Rosa Ranch", EnumSet.of(Animal.HORSE, Animal.CAT, Animal.DUCK));
		Farm f4 = new Farm("Maple Leaf Farm", EnumSet.of(Animal.DUCK, Animal.CAT));
		FeedLot f5 = new FeedLot("Pig Feed Lot", EnumSet.of(Animal.PIG, Animal.CAT, Animal.HORSE));
		
		final List<Farm> l = new ArrayList<>();
		l.add(f1);
		l.add(f2);
		l.add(f3);
		l.add(f4);
		l.add(f5);
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("farms.ser"))){
			out.writeObject(l);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		List<Farm> l2 = new ArrayList<>();
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("farms.ser"))){
			l2 = (List<Farm>) in.readObject();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		l2.forEach(o->System.out.println(o));
		
		//Map<Animal, List<Farm>> m = l2.stream().collect(Collectors.groupingBy(wert ->wert.getAnimals().));
		Map<Animal, List<Farm>> m = new HashMap<>();
		for(Farm f: l2) {
			
			m.put(f.getAnimals().iterator().next(), l2);
			
		}
		
		
		
		for(Entry<Animal, List<Farm>> map : m.entrySet()) {
			Collections.shuffle(map.getValue());
		}
		
		m.forEach((k,v)->System.out.println(k + "=" + v));
		
		
		Comparator<Farm> comp = Comparator.comparing(Farm::getVolume, (a,b)->{return a.compareTo(b);});
		
		for(Entry<Animal, List<Farm>> map : m.entrySet()) {
			Collections.sort(map.getValue(), comp);
		}
		
		
		m.forEach((k,v)->System.out.println(k + "=" + v.get(0)));
		}catch(IllegalArgumentException ex) {
			ex.getMessage();
		}
	
		
	}

}
