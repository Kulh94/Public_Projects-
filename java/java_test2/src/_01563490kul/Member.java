package _01563490kul;

import java.io.Serializable;
import java.util.EnumSet;

@SuppressWarnings("serial")
public class Member implements Serializable{
	
	private String name;
	private EnumSet<Species> species = EnumSet.noneOf(Species.class);
	
	public Member(String name, EnumSet<Species> species) {
		super();
		this.name = name;
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.isEmpty()  || name == null)throw new IllegalArgumentException("name is not valid");
		this.name = name;
	}

	public EnumSet<Species> getSpecies() {
		return species;
	}

	public void setSpecies(EnumSet<Species> species) {
		if(species.isEmpty()  || species == null)throw new IllegalArgumentException("species is not valid");
		this.species = species;
	}
	
	public String getAllWords() {
		String result = "";
		
		for(Species s : species) {
			result += s.getSpruch() + " and ";
		}
		int b=result.length()-4;
		
		return result.substring(0, b);
	}
	
	public int getReputation() {
		int result = 0;
		
		for(Species s : species) {
			result += s.getSpruch().length() * 2500;
		}
		return result;
	}

	@Override
	public String toString() {
		return "[ " + name + " " + species + " " + getAllWords()
				+ " " + getReputation() + "]";
	}
	
	
	
	

}
