package kul;

public enum Fertigkeit {
	
	  MATHEMATIK(30),
	  GEOGRAFIE(10),
	  GESCHICHTE(), 
	  ENGLISCH(),
	  FRANZOESISCH(), 
	  LITERATUR(), 
	  SPORT(10),
	  PROGRAMMIEREN(40), 
	  JAPANISCH(40);

	private int grundwert;
	
	Fertigkeit(){
		this.grundwert=20;
	}
	
	Fertigkeit(int grundwert){
		this.grundwert=grundwert;
	}
	
	@Override
	public String toString() {return name();}

	int getBonus(int stufe) {
	  if(Fertigkeit.this==PROGRAMMIEREN) {
		 return (grundwert+stufe*100);
	  }
	  return grundwert*stufe;
	  
    }

}


