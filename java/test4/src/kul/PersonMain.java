package kul;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PersonMain {

	public static void main(String[] args) {
		
		Set<Fertigkeit> s = new TreeSet<>();
	
		Set<Fertigkeit> ex = new TreeSet<>();
		
		s.add(Fertigkeit.PROGRAMMIEREN);
		Person p1 = new Person("Hans","Mueller",19,176,78,s);
		s.clear();
		
		s.add(Fertigkeit.MATHEMATIK);
		Person p3 = new Person("Lisa","Meyer",22,172,80,s);
		s.clear();
		
		
		s.add(Fertigkeit.PROGRAMMIEREN);
		s.add(Fertigkeit.MATHEMATIK);
		ex.add(Fertigkeit.PROGRAMMIEREN);
	
		
		Person p2 = new ExpertIn("Herbert","Bauer",25,180,60,s,ex);
		
		p3.trainieren(Fertigkeit.PROGRAMMIEREN);
		p2.trainieren(Fertigkeit.MATHEMATIK);
	
		System.out.println(p1);
		System.out.println(p3);
		System.out.println(p2);
		p1.lernen(p3, Fertigkeit.MATHEMATIK);
		p2.lernen(p3, Fertigkeit.PROGRAMMIEREN);
		p3.trainieren(Fertigkeit.MATHEMATIK);
		p2.trainieren(Fertigkeit.PROGRAMMIEREN);
		System.out.println(p1);
		System.out.println(p3);
		System.out.println(p2);
		
		List<Person> ps= new ArrayList<>();
		ps.add(p1);
		ps.add(p2);
		ps.add(p3);
		
		Collections.sort(ps);
		System.out.println(ps);
		
		Collections.sort(ps, new Comparator<Person>() {  
		     @Override  
		      public int compare(Person a, Person b){  
		    	  if(a.getGewicht() > b.getGewicht())
		    			return 1;
		    		if(a.getGewicht() < b.getGewicht())
		    			return -1;
		    		
		    		return 0;
		    	  
		      }
		          
		});
		
		
		System.out.println(ps);
		
		

		Collections.sort(ps, new Comparator<Person>() {  
		     @Override  
		      public int compare(Person a, Person b){  
		    	  if(a.getGroesse() > b.getGroesse())
		    			return 1;
		    		if(a.getGroesse() < b.getGroesse())
		    			return -1;
		    		
		    		return 0;
		    	  
		      }
		          
		});
		
		
		System.out.println(ps);
		
		Collections.sort(ps, new Comparator<Person>() {  
		     @Override  
		      public int compare(Person a, Person b){  
		    	  if(a.getGroesse() > b.getGroesse())
		    			return 1;
		    		if(a.getGroesse() < b.getGroesse())
		    			return -1;
		    		
		    		return 0;
		    	  
		      }
		          
		});
		
		
		System.out.println(ps);
		
    
	}
}

