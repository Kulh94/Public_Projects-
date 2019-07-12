package TEST5;

import java.io.Serializable;
import java.util.EnumSet;

public class Member implements Serializable{

	private String name;
	private EnumSet<Species> species = EnumSet.noneOf(Species.class);
	
	public Member(String name, EnumSet<Species> species) {
		if(name == null || name.isEmpty()) throw new IllegalArgumentException("name not valid");
		if(species == null || species.isEmpty()) throw new IllegalArgumentException("species not valid");
		this.name = name;
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumSet<Species> getSpecies() {
		return species;
	}

	public void setSpecies(EnumSet<Species> species) {
		this.species = species;
	}
	
	public String getAllWords() {
		String result = "";
		
		for(Species s : species) {
			result += s.getSpruch() + " and ";
		}
		Integer lenght= result.length()-4;
		return result.substring(0,lenght);
	}
	
	public Integer getReputation() {
		String result ="";
		
		for(Species s: species) {
			result += s.getSpruch();
		}
		return result.length() *2500;
		
	}

	@Override
	public String toString() {
		return "[" + name + ", " + getAllWords() + ", " + getReputation()
				+ "]";
	}
	
	
	
}
