package Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		ArrayList<Zauber> arrl = new ArrayList<Zauber>();
		arrl.add(Zauber.FERULA);
		arrl.add(Zauber.LEVIOSA);
		arrl.add(Zauber.LEVIOSA);
		arrl.add(Zauber.FERULA);
		

		ArrayList<Zauber> arrl2 = new ArrayList<Zauber>();
		arrl2.add(Zauber.IMPERIO);
		arrl2.add(Zauber.IMPERIO);
		arrl2.add(Zauber.FERULA);
		
		ArrayList<Zauber> arrl3 = new ArrayList<Zauber>();
		arrl3.add(Zauber.LEVIOSA);
		arrl3.add(Zauber.LEVIOSA);
		
		Inferno invincibilis = new Inferno("Invincibilis", arrl);
		Inferno destructo = new Inferno("Destructo", arrl2);
		Inferno admirabile = new Inferno("Admirabile", arrl3);
	
		
		System.out.println(invincibilis);
		System.out.println(destructo);
		System.out.println(admirabile);
		
		
		
	
		Map<String, Kette> kettemap = new HashMap<>();
		kettemap.put(invincibilis.sprechen().substring(0,2), invincibilis);
		kettemap.put(destructo.sprechen().substring(0,2), destructo);
		kettemap.put(admirabile.sprechen().substring(0,2), admirabile);
		
		
		FileOutputStream fileOut = new FileOutputStream("kette.map");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(kettemap);
		out.close();
		fileOut.close();
		
		
		FileInputStream fileIn = new FileInputStream("kette.map");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		kettemap = (Map<String, Kette>) in.readObject();
		in.close();
		fileIn.close();
		
		System.out.println(kettemap);
		
		List<Kette> l = new ArrayList<>();
		
		l.add(invincibilis);
		l.add(destructo);
		l.add(admirabile);
		
	    Collections.shuffle(l);
	    
	    for(Kette k : l) {
	    	System.out.println(k);
	    }
	    
	  //  System.out.println(l);
	    
	    Collections.sort(l, new Comparator<Kette>(){
	    	
	    	@Override
	    	public int compare(Kette rop, Kette lop) {
	    		int a = rop.sprechen().length();
	    		int b = lop.sprechen().length();
	    		
	    		return a - b;
	    	}
	    	
	    });
	    
	    for(Kette k : l) {
	    	System.out.println(k);
	    }
	    
		
		
	
	}

	

	
	
}
