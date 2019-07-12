package Test5;

public enum Typ {

	HEILUNG(5),
	SCHUTZ(2),
	HEX(3);
	
	private final int wert;

	private Typ(int wert) {
		this.wert = wert;
	}

	public int getWert() {
		return wert;
	}
	
}
