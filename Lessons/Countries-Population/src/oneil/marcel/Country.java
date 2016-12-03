package oneil.marcel;

public class Country implements Comparable<Object> {
	private String name;
	private long population;

	public Country(String name, long population) {
		this.name = name;
		this.population = population;
	}

	public Country(String csv) {
		String[] values = csv.split(",");
		this.name = values[0];
		this.population = Long.parseLong(values[1]);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public long getPopulation() {
		return this.population;
	}
	
	public char firstLetter() {
		return Character.toUpperCase(this.getName().toCharArray()[0]);
	}

	@Override
	public int compareTo(Object country1) {
		// TODO Auto-generated method stub
		return Long.compare(((Country) country1).getPopulation(), this.getPopulation());
	}
}
