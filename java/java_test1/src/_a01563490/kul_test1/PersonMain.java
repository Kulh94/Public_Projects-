package _a01563490.kul_test1;

import java.util.Set;
import java.util.TreeSet;


public class PersonMain{
	
	

	public static void main(String[] args) {
		
		Set<Skill> s1 = new TreeSet<>();
		Set<Skill> ex1 = new TreeSet<>();
		s1.add(Skill.HISTORY);
		s1.add(Skill.SPORTS);
		ex1.add(Skill.PROGRAMMING);
		
		Expert e1 = new Expert("Anton", "Schleich", 60, 185, 85, s1, ex1);
		//System.out.println(e1);
		
		Set<Skill> s2 = new TreeSet<>();
		Set<Skill> ex2 = new TreeSet<>();
		s2.add(Skill.LITERATURE);
		s2.add(Skill.HISTORY);
		ex2.add(Skill.ENGLISH);
		
		Expert e2 = new Expert("Johanna", "Herbst", 42, 178, 65, s2, ex2);
		//System.out.println(e2);
		
		Set<Skill> s3 = new TreeSet<>();
		s3.add(Skill.LITERATURE);
		s3.add(Skill.PROGRAMMING);
		s3.add(Skill.ENGLISH);
		
		
		Person p1 = new Person("Petra", "Stein", 22, 167, 77, s3);
		//System.out.println(p1);
		
		/*e2.learn(p1, Skill.ENGLISH);
		e2.practise(Skill.ENGLISH);
		e1.learn(e2, Skill.LITERATURE);
		e2.practise(Skill.PROGRAMMING);
		p1.learn(e2, Skill.SPORTS);
		e2.practise(Skill.PROGRAMMING);
		e1.practise(Skill.PROGRAMMING);*/
		
		System.out.println(e2.learn(p1, Skill.ENGLISH));
		System.out.println(e2.practise(Skill.ENGLISH));
		System.out.println(e1.learn(e2, Skill.LITERATURE));
		System.out.println(e2.practise(Skill.PROGRAMMING));
		System.out.println(p1.learn(e2, Skill.SPORTS));
		System.out.println(e2.practise(Skill.PROGRAMMING));
		System.out.println(e1.practise(Skill.PROGRAMMING));
		
		Set<Person> out = new TreeSet<>();
		
		out.add(p1);
		out.add(e1);
		out.add(e2);
		System.out.println(out);
		
		try {
		PrivateTutor[] arr = {p1,e1,e2};
		System.out.println(PersonUtils.allBelow(arr, null));
		System.out.println(PersonUtils.allBelow(arr, 600));
		System.out.println(PersonUtils.allBelow(null, null));
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
