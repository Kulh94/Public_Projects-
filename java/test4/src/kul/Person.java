package kul;

import java.util.*;   

public class Person implements Comparable <Person>{
	private String firstname;
	private String lastname;
	private int age = 20;
	private int heightCm = 180;
	private double weightKg = 70;
	
	Map<Skill, Integer> fertigkeitPerson = new TreeMap<Fertigkeit, Integer>();
	
	
Person(String vorname, String nachname, int alter,int groesse,double gewicht, Set<Fertigkeit> setList){
		
		if(alter<10 || alter>100){
			throw new IllegalArgumentException(
			          "age out of range: " + alter +
			              " expected range 10 <= age < 100"
			              );
		}
		
		
		if(groesse<100 || groesse>250){
			throw new IllegalArgumentException(
			          "hight out of range: " + groesse +
			              " expected range 100 <= age < 250"
			              );
		}
		
		
		if(gewicht<20 || gewicht>300){
			throw new IllegalArgumentException(
			          "weight out of range: " + gewicht +
			              "expected range 20 <= age < 300 "
			              );
		}
		
		
		this.firstname=vorname;
		this.lastname=nachname;
		this.age=alter;
		this.heightCm=groesse;
		this.weightKg=gewicht;       
		
		for (Fertigkeit neueFertigkeit : setList) {
			fertigkeitPerson.put(neueFertigkeit, 0);
		}

	}

Person(String vorname, String nachname) {
	this.firstname = vorname;
	this.lastname = nachname;
	age = 25;
	heightCm = 170;
	weightKg = 70;
}



boolean aelterAls(Person p) {

	return this.age>p.age;
}

boolean groesserAls(Person p) {
	
	return this.heightCm>p.heightCm;
			
}
	

boolean schwererAls(Person p) {
  
	return this.weightKg>p.weightKg;	
}


public double getGewicht(){  
    return this.weightKg;  
} 

public int getGroesse(){  
    return this.heightCm;  
} 

boolean lernen(Person p, Fertigkeit f) {
	if (this.fertigkeitPerson.containsKey(f)) {
		System.out.println("!!Lehrende Person beherrscht Fertigkeit nicht: Fertigkeit=" + f.name());
		
		              
		return false;
	}
	
	if (!p.fertigkeitPerson.containsKey(f)) {
		System.out.println("!!Lernende Person dar Fertigkeit nicht beherrschen: Fertigkeit = " + f.name());
		return false;
	}
	
	for(Fertigkeit fl : this.fertigkeitPerson.keySet()) {
		if (!p.fertigkeitPerson.containsKey(fl)) {
			p.fertigkeitPerson.put(fl, 0);
			this.fertigkeitPerson.put(f, 0);
		}
		return true;
	}
	
	return false;
}

boolean trainieren(Fertigkeit f) {
	if (fertigkeitPerson.containsKey(f)) {
		fertigkeitPerson.put(f, fertigkeitPerson.get(f) + 1);
		return true;
	}
	return false;
}

@Override
public String toString() {
	return "Person [" +"vn="+firstname + ", " +"nn="+lastname +", " +"age="+ age + ", " + "sz=" +heightCm + ", " +"wg="+ weightKg + ", " +"map="+ fertigkeitPerson + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	long temp;
	temp = Double.doubleToLongBits(weightKg);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + heightCm;
	result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
	result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	if (age != other.age)
		return false;
	if (Double.doubleToLongBits(weightKg) != Double.doubleToLongBits(other.weightKg))
		return false;
	if (heightCm != other.heightCm)
		return false;
	if (lastname == null) {
		if (other.lastname != null)
			return false;
	} else if (!lastname.equals(other.lastname))
		return false;
	if (firstname == null) {
		if (other.firstname != null)
			return false;
	} else if (!firstname.equals(other.firstname))
		return false;
	return true;
}

@Override
public int compareTo(Person o) {
	// TODO Auto-generated method stub
	
	if(this.age > o.age)
		return 1;
	if(this.age < o.age)
		return -1;
	
	return 0;
}



}
