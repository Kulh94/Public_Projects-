package _a01563490.kul_test1;


import java.util.Set;
import java.util.TreeSet;


public class Expert extends Person{
	

	final Set<Skill> skillExpert = new TreeSet<Skill>();
	
	public Expert(String firstname, String lastname, int age, int heightCm, double weightKg, Set<Skill>skills, Set<Skill>specialisedSkills) {
		
		super(firstname, lastname, age, heightCm, weightKg, skills);
		
		if(specialisedSkills.size() == 0) 
		{
			throw new IllegalArgumentException("Expert have not skills");
			
		} else	if (specialisedSkills.size() > 3)
		        {
			       try {
				         throw new Exception("Expert have more than 3 Skill");
			           } catch (Exception e) 
			         { 
				      e.printStackTrace();
			         }
		        } else  skillExpert.addAll(specialisedSkills); 
	}
	

	@Override
	public boolean practise(Skill skill) {
		if (skillExpert.contains(skill)) {
			super.practise(skill);
			super.practise(skill);
		}
		return super.practise(skill);
	}


	@Override
	public String toString() {
		return "" + super.toString()  + skillExpert; 
	}
	
	@Override
	public int holdLesson() {
		return super.holdLesson() + skillExpert.size() * 50;
	}
	
	
}
