package kul;


import java.util.Set;
import java.util.TreeSet;

public class ExpertIn extends Person {
	
	final Set<Fertigkeit> fertigkeitExpert = new TreeSet<Fertigkeit>();

	public ExpertIn(String vorname, String nachname, int alter, int groesse, double gewicht, Set<Fertigkeit> setList,
			Set<Fertigkeit> expertList) {
		super(vorname, nachname, alter, groesse, gewicht, setList);

		fertigkeitExpert.addAll(expertList);
		if (expertList.size() > 3) {
			try {
				throw new Exception("Experte hat meht als 3 ExpertFertigkeiten");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ExpertIn(String vorname, String nachname) {
		super(vorname, nachname);
	}
	
	@Override
	boolean trainieren(Fertigkeit f) {
		if (fertigkeitExpert.contains(f)) {
			super.trainieren(f);
			super.trainieren(f);
		}
		return super.trainieren(f);
	}
	
}


