package _a01563490.kul;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Person  implements Comparable<Person>, Ressource, Schwimmt{
	
	private String firstname;
	private String lastname;
	private int age = 20;
	private int heightCm = 180;
	private double weightKg = 70;
	private static final int MIN_AGE = 10;
	private static final int MAX_AGE = 100;
	private static final int MIN_WEIGHT = 20;
	private static final int MAX_WEIGHT = 200;
	private static final int MIN_HEIGHT = 100;
	private static final int MAX_HEIGHT = 250;
	
	private Map<Skill, Integer> skillLevel;
	
	public Person(String firstname, String lastname, int age, int heightCm, double weightKg, Set<Skill> skillLevel) {
	  
	  setFirstname(firstname);
	  setLastname(lastname);
	  setAge(age);
	  setHeightCm(heightCm);
	  setWeightKg(weightKg);
		
	  if(skillLevel.isEmpty() || skillLevel == null)
	    throw new IllegalArgumentException(" skillLevel is either empty or is equall to null");
	  
	  
		this.skillLevel = new LinkedHashMap<Skill, Integer>();
		for (Skill ski : skillLevel) 			
			this.skillLevel.put(ski, 0);
				
	}
	
	
	public Person(String firstname, String lastname,Set<Skill> skillLevel) {
		this(firstname, lastname, 20, 180, 70, skillLevel);
	}
	



public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		  if(firstname != null && firstname != "")
			  this.firstname = firstname;
			else throw new IllegalArgumentException("Incorrect firstname");
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
      if(lastname != null && lastname != "")
		    this.lastname = lastname;
		  else throw new IllegalArgumentException("Incorrect lastname");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		  if(age >= MIN_AGE &&  age <= MAX_AGE)
			  this.age = age;
		  else throw new IllegalArgumentException("Incorrect age");
	}

	public int getHeightCm() {
		return heightCm;
	}

	public void setHeightCm(int heightCm) {
	   	if(heightCm >= MIN_HEIGHT && heightCm <= MAX_HEIGHT)
			  this.heightCm = heightCm;
		  else throw new IllegalArgumentException("Incorrect heightCm");
	}

	public double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(double weightKg) {
		  if(weightKg >= MIN_WEIGHT && weightKg <= MAX_WEIGHT)
		  	this.weightKg = weightKg;
		  else throw new IllegalArgumentException("Incorrect weightKg");
	}

	
	
	
	public boolean olderThan(Person other) {
		if(this.age > other.age)
			return true;
		else return false;
	}
	
	public boolean greaterThan(Person other) {
		if(this.heightCm > other.heightCm)
			return true;
		else return false;
	}
	
	public boolean heavierThan(Person other) {
		if(this.weightKg > other.weightKg)
			return true;
		else return false;
	}

	@Override
	public String toString() {
		String map = " Skill = { ";
		for (Skill temp : this.skillLevel.keySet()) {
			map+= temp + "=" + this.skillLevel.get(temp) + " ";		    
		}		
		return "Person: [firstname = " + firstname + ", lastname = " + lastname + " (" + "age = " + age + ", heightCm = " + heightCm
				+ ", weightKg = " + weightKg + ")" +  "," + map + "}]";
	}
	
	
	public boolean learn(Person other, Skill skill) {
		
		if(this.skillLevel.containsKey(skill)){
	        System.out.println("not allowed to know skill: = " + skill.name());
		    return false;
	     }
			if (!other.skillLevel.containsKey(skill)) {
				System.out.println("other must know skill: = " + skill.name());
				return false;
			}
			
		    for(Skill ski : this.skillLevel.keySet()) {
				if (!other.skillLevel.containsKey(ski)) {
					other.skillLevel.put(ski, 0);
					this.skillLevel.put(skill, 0);
		       return true;	
				}
				
			}
		   return false;
		}
	
	
	public boolean practise(Skill skill) {
      if(this.skillLevel.containsKey(skill)) {
    	 this.skillLevel.put(skill, this.skillLevel.get(skill)+1);
    	  return true;
        } else return false;
		
	}
	

	private int getBonus() {
		int gesamtBonus = 0;
		for (Skill temp : skillLevel.keySet()) {
			gesamtBonus += temp.getBonus(skillLevel.get(temp));
		}
		return gesamtBonus;
	}
	
	

	@Override
	public int compareTo(Person person) {
		
		return this.age - person.age;
	}
	
	
    
    public static Comparator<Person> compareByWeight = (new Comparator<Person>(){
    	   public int compare(Person a, Person b)
		   {
			 return (int) (a.getWeightKg() - b.getWeightKg());
		   }
	});
    
    
    public static Comparator<Person> compareByHeight = (new Comparator<Person>(){
    	  public int compare(Person a, Person b)
		  {
			return a.getHeightCm() - b.getHeightCm();
		  }
	});
    

    public static Comparator<Person> compareByBonus = (new Comparator<Person>(){
  	  public int compare(Person a, Person b)
	  {
		return a.getBonus() - b.getBonus();
	  }
	});

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
      result = prime * result + heightCm;
      result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
      result = prime * result + ((skillLevel == null) ? 0 : skillLevel.hashCode());
      long temp;
      temp = Double.doubleToLongBits(weightKg);
      result = prime * result + (int) (temp ^ (temp >>> 32));
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
      if (firstname == null) {
        if (other.firstname != null)
          return false;
      } else if (!firstname.equals(other.firstname))
        return false;
      if (heightCm != other.heightCm)
        return false;
      if (lastname == null) {
        if (other.lastname != null)
          return false;
      } else if (!lastname.equals(other.lastname))
        return false;
      if (skillLevel == null) {
        if (other.skillLevel != null)
          return false;
      } else if (!skillLevel.equals(other.skillLevel))
        return false;
      if (Double.doubleToLongBits(weightKg) != Double.doubleToLongBits(other.weightKg))
        return false;
      return true;
    }


	@Override
	public int kosten() {
		return getAge() *5;
	}


	@Override
	public int leange() {
		int diff = (int) (getWeightKg() *10);
		return 2000 - diff;
	}



 }
	
	
