package Test;

public enum Zauber {
	
	FERULA("aahh"),
	LEVIOSA ("oooh"),
	IMPERIO("ihhh");
	
	private final String laut;
	
	Zauber(String laut){this.laut=laut;}
	
	public String getLaut() {
		return laut;
	}
	
	
	

}
