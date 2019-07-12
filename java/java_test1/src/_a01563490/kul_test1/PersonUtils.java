package _a01563490.kul_test1;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class PersonUtils {
	
	public static Set<PrivateTutor> allBelow(final PrivateTutor[] arr, final Integer threshold) throws NullPointerException{
		SortedSet<PrivateTutor> erg = new TreeSet<PrivateTutor>();
		//TreeSet<PrivateTutor> reverce = (TreeSet<PrivateTutor>)erg.descendingSet();
		if(arr == null) {
			throw new IllegalArgumentException("No Tutor Objects!");
		}
		
		if(threshold == null) {
			for(PrivateTutor a : arr) {
				if(a.holdLesson() < 250) {
					erg.add(a);
				}
			}
			
	
			
			return erg;
		}
		
		for(PrivateTutor a : arr) {
			if(a.holdLesson() < threshold) {
				erg.add(a);
			}
		}
		
		return erg;
	}
	
	

}
