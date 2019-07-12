package TEST5NT;

import java.util.EnumSet;

public class Ruler extends FamilyMember{

	public Ruler(String name, EnumSet<FamilyLineage> families) {
		super(name, families);
	}

	public Integer getPrestige() {
		return super.getPrestige() + super.getName().length();
		}
	
}
