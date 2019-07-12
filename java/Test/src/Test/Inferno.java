package Test;

import java.util.ArrayList;

public class Inferno extends Kette {

	public Inferno(String name, ArrayList<Zauber> arr) {
		super(name, arr);
	}

	@Override
	public String sprechen() {
		return super.sprechen()+ "-Maximus";
	}

}
