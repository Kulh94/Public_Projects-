package TEST5;

public enum Species {
	
	BORG("You will be assimilated"),
	VULCAN("Live long and prosper"),
	BETAZOID("Thank the four deities"),
	HUMAN("Everyone remember where we parked"),
	KLINGON("We are Klingons");
	
	private final String spruch;

	private Species(String spruch) {
		this.spruch = spruch;
	}

	public String getSpruch() {
		return spruch;
	}
	
	@Override
	public String toString() {
		return "[" + this.name() + ": " + getSpruch() + "]";
	}
	

}
