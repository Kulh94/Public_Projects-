package TEST5NT;

import java.io.Serializable;
import java.util.EnumSet;

public class FamilyMember implements Serializable {

	private String name;
	private EnumSet<FamilyLineage> families = EnumSet.noneOf(FamilyLineage.class);
	
	public FamilyMember(String name, EnumSet<FamilyLineage> families) {
		if(name.isEmpty() || name == null) throw new IllegalArgumentException("name not valid");
		if(families.isEmpty() || families == null) throw new IllegalArgumentException("families not valid");

		this.name = name;
		this.families = families;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumSet<FamilyLineage> getFamilies() {
		return families;
	}

	public void setFamilies(EnumSet<FamilyLineage> families) {
		this.families = families;
	}
	
	public String getAllWords() {
		String result = "";
		for(FamilyLineage f : families) {
			result += f.getSpruch() + " and ";
		}
		return result.substring(0, result.length()-4);
	}
	
	public Integer getPrestige() {
		String result = "";
		for(FamilyLineage f : families) {
			result += f.getSpruch();
		}
		return result.length() * 1000;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + getAllWords()
				+ ", " + getPrestige() + "]";
	}
	
	
	
}
