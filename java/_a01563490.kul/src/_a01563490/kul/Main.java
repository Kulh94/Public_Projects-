package _a01563490.kul;

import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static int find(Ressource[] arr) {
		int hohste = 0;
		for(Ressource r: arr)
		{
			if(r.kosten() > hohste)
				 hohste = r.kosten();
		}
		
		return  hohste;
	}
	
	public static int finds(Schwimmt[] arr) {
		int laengste = 0;
		
		for(Schwimmt s : arr) {
			if(s.leange() > laengste) {
				laengste = s.leange();
			}
		}
		return laengste;
	}

	

	public static void main(String[] args) {
	
		/*Set<Skill> skill1 = new TreeSet<Skill>();
		Set<Skill> skill2 = new TreeSet<Skill>();
		
		skill1.add(Skill.ENGLISH);
		skill2.add(Skill.JAPANESE);
		
		try {
			Person p1 = new Person("Max", "Muster", 50, 150, 80, skill1);
			System.out.println(p1);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
			try {
				Person p2 = new Person("Max", "Muster", 50, 80, 0, skill2);	
				System.out.println(p2);
			}catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());*/
		
		Set<Skill> s1 = new TreeSet<>();
		Set<Skill> s2 = new TreeSet<>();
		Set<Skill> s3 = new TreeSet<>();
		
		Set<Skill> ex = new TreeSet<>();
		try {
		s1.add(Skill.PROGRAMMING);
		Person p1 = new Person("Hans","Mueller",19,175,78,s1);
		System.out.println(p1);
		//s.clear();
		
		s2.add(Skill.MATH);
		Person p3 = new Person("Lisa","Meyer",22,180,80,s2);
		//s.clear();
		
		s3.add(Skill.MATH);
		s3.add(Skill.PROGRAMMING);
		ex.add(Skill.PROGRAMMING);
		ex.add(Skill.ENGLISH);
	
		Person p2 = new Expert("Herbert","Bauer",22,170,60,s3,ex);
		
		p3.practise(Skill.PROGRAMMING);
		p2.practise(Skill.MATH);
	
	
		System.out.println(p3);
		System.out.println(p2);
		p1.learn(p3, Skill.MATH);
		p2.learn (p3, Skill.PROGRAMMING);
		p3.practise(Skill.MATH);
		p2.practise(Skill.PROGRAMMING);
		System.out.println(p1);
		System.out.println(p3);
		System.out.println(p2);
		
		System.out.println(p1.kosten() + "€");
		System.out.println(p2.kosten() + "€");
		
		
		Ressource[] arr = {p1,p2,p3};
		
		/*
		for(Ressource p: arr)
		{
			System.out.println(p.kosten());
		}*/
		
		System.out.println(find(arr)+ "Haloo Adam");
		
		
		System.out.println(p1.leange() + "m");
		System.out.println(p2.leange() + "m");
		
		
		
		Schwimmt[] arr2 = {p1,p2,p3};
		System.out.println(finds(arr2));
		
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		
		
		

		
		
		
	}
}
