package Test;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Kette implements Serializable{
	
	private String name;
	private ArrayList<Zauber> arr;
	
	
	public Kette(String name, ArrayList<Zauber> arr) {
		this.name = name;
		this.arr = arr;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Zauber> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Zauber> arr) {
		this.arr = arr;
	}

	public String sprechen() {
		String result="";
		for(Zauber z: arr)
		{
			result+= z.getLaut() + "-";
		}
		return result;
	}

	@Override
	public String toString() {
		return "Kette [Name: " + name + ", Zauber: " + arr + ", Laute: " + sprechen() + "]";
	}


	
	
	
	
}
	