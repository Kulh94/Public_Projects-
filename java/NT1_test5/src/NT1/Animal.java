package NT1;

public enum Animal {

	CAT("Miaou"),
	DOG("Wooff"),
	CATTLE("Muuuhhh"),
	HORSE("Whiiieeeahhh"),
	DUCK("Quack"),
	PIG("Oink");
	
	private final String laut;

	private Animal(String laut) {
		this.laut = laut;
	}

	public String getLaut() {
		return laut;
	}
	

	
	@Override
	public String toString() {
		return "[" + this.name() + ": "+ getLaut() + "]";
	}
	
}
