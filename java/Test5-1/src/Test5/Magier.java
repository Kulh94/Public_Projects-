package Test5;

import java.util.EnumSet;

public class Magier extends Zauberer{


	public Magier(String name, EnumSet<Typ> zaubertyp) {
		super(name, zaubertyp);
	}

	public int getAnsehen() {
		return super.getAnsehen() * 3;
	}
		
}
