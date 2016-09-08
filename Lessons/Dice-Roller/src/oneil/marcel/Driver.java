package oneil.marcel;

public class Driver {

	public static void main(String[] args) {
		Die firstDie = new Die(6);
		Die secondDie = new Die(6);
		
		firstDie.roll();
		secondDie.roll();
		int total = firstDie.getValue() + secondDie.getValue();
		
		System.out.println("Dice roll was " + total);
	}

}
