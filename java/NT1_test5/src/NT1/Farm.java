package NT1;

	import java.io.Serializable;
	import java.util.EnumSet;
	
	public class Farm implements Serializable{

		private String name;
		private EnumSet<Animal> animals = EnumSet.noneOf(Animal.class);
		
		public Farm(String name, EnumSet<Animal> animals) {
			if(name == null || name.isEmpty()) throw new IllegalArgumentException("name not valid");
			if(name == null || animals.isEmpty()) throw new IllegalArgumentException("animal not valid");
			
			this.name = name;
			this.animals = animals;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public EnumSet<Animal> getAnimals() {
			return animals;
		}

		public void setAnimals(EnumSet<Animal> animals) {
			this.animals = animals;
		}
		
		public String getAllSounds() {
			String result= "";
			for(Animal a: animals) {
				result += a.getLaut() + " - ";
			}
			return result.substring(0, result.length()-2);
		}
		
		public double getVolume() {
			String result= "";
			for(Animal a: animals) {
				result += a.getLaut();
			}
			return result.length()/10.0;
		}
		
		

		@Override
		public String toString() {
			return "[" + name + ", " + getAllSounds() + ", " + getVolume() + "]";
		}
		
		
		
		
	}

	

