package TEST5NT;

public enum FamilyLineage {

	BARATHEON("Ours is the Fury"),
	TARAGARYEN("Fire and Blood"),
	STARK("Winter is Coming"),
	LANNISTER("Hear Me Roar"),
	TYRELL("Growing Strong");
	
	private final String spruch;

	private FamilyLineage(String spruch) {
		this.spruch = spruch;
	}

	public String getSpruch() {
		return spruch;
	}
	
	@Override
	public String toString() {
		return "[" + this.name() + " " + getSpruch() + "]";
	}
	
}
