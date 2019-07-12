package TEST5;

import java.util.EnumSet;

public class Commander extends Member {

	public Commander(String name, EnumSet<Species> species) {
		super(name, species);
	}

	@Override
	public Integer getReputation() {
		return super.getReputation() + super.getName().length();
	}

}
