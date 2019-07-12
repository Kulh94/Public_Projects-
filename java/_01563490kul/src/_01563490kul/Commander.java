package _01563490kul;

import java.util.EnumSet;

@SuppressWarnings("serial")
public class Commander extends Member{

	public Commander(String name, EnumSet<Species> species) {
		super(name, species);
		
	}
	@Override
	public int getReputation() {
		return super.getReputation() + super.getName().length();
	}
}
