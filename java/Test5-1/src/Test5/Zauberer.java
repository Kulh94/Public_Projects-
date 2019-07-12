package Test5;

import java.util.EnumSet;

public class Zauberer {
	
	private String name;
	private EnumSet<Typ> zaubertyp = EnumSet.noneOf(Typ.class);

	public Zauberer(String name, EnumSet<Typ> zaubertyp) {
		this.name = name;
		this.zaubertyp = zaubertyp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumSet<Typ> getZaubertyp() {
		return zaubertyp;
	}

	public void setZaubertyp(EnumSet<Typ> zaubertyp) {
		this.zaubertyp = zaubertyp;
	}
	
	
	public int getAnsehen() {
		int result=0;
		for(Typ t: zaubertyp) {
			result += t.getWert();
		}
		return result;
	}

	@Override
	public String toString() {
		return "Zauberer [name=" + name + ", zaubertyp=" + zaubertyp + ", getAnsehen()=" + getAnsehen() + "]";
	}
	
	

}
