package _a01563490.kul;


public enum Skill {
	
	MATH(30),
	GEOGRAPHY(10),
	HISTORY(),
	ENGLISH(),
	FRENCH,
	LITERATURE,
	SPORTS(10),
	PROGRAMMING(40) {	@Override
		public int getBonus(int level) { return getBase() + level * 100; }
	}, 
	JAPANESE(40);

	private final int base;
	

	
	Skill (int base) { this.base = base; }
	
	Skill () { base = 20;}
	
	public int getBase() { return base;}
	
	public int getBonus(int level) { return getBase() * level;}
	
}

