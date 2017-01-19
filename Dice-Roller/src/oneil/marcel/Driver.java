package oneil.marcel;

public class Driver {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		Die die2 = new Die(6);
		int[] rolls = new int[11];
		
		for(int i = 0; i < 1000; i++){
			die1.roll();
			die2.roll();
			int total = die1.getValue() + die2.getValue();
			rolls[total-2] ++;
		}
		
		for(int i = 0; i < 11; i++){
			System.out.println("Roll sum " + (i+2) + ": " + rolls[i]);
		}
		System.out.println("I found " + rolls[5] + " rolls with a sum of 7");
		System.out.println("The theoretical probability is 16.7%");
		System.out.printf("The experimental probability is %.1f%%\n", (float) rolls[5] / 10);
	}

}
