package NT1;

import java.util.EnumSet;

public class FeedLot extends Farm {

	public FeedLot(String name, EnumSet<Animal> animals) {
		super(name, animals);
	
	}
	
	@Override
	public double getVolume() {
		return super.getVolume() *10;
	}

}