package _01563490kul;

public enum Species {
	
	BORG("You will be assimilated"),
	VULCAN("Live long and prosper"),
	BETAZOID("Thank the four deities"),
	HUMAN("Everyone remember where we parked"),
	KILNGON("We are Klingons");
	
	public final String spruch;

	private Species(String spruch) {
		this.spruch = spruch;
	}

	public String getSpruch() {
		return spruch;
	}
	
	
}
