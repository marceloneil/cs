package oneil.marcel;

import java.util.HashMap;
import java.util.Map;



public class HashDriver {

	public static void main(String[] args) {
		int NUM_SIDES = 6;
		Die die1 = new Die("First Die", NUM_SIDES);
		Die die2 = new Die("Second Die", NUM_SIDES);

		
		int countSevens = 0;
		int sum =0;
		int[] sums = new int[1000];
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

		for (int i = 0; i < 1000; i++) {
			die1.roll2();
			die2.roll2();
			sum = die1.getValue() + die2.getValue();
			sums[i] = sum;
			if (sum == 7) {
				countSevens++;
			}
		}
		
		for (int sumValue : sums){
			if (counts.containsKey(sumValue)){
				counts.put(sumValue, counts.get(sumValue) + 1); // increase count
			}
			else {
				counts.put(sumValue, 1);
			}
		}
		
		for (int i = 2; i<13; i++){
			System.out.println("Roll sum " + i + ": " + counts.get(i));
		}
	
		System.out.println("I found " + countSevens + " rolls with a sum of 7");
		System.out.printf("The theoretical probability is %.1f%%\n", (float) 1 / 6 * 100);
		System.out.printf("The experimental probability was %.1f%%", (float) countSevens / 1000 * 100);
	
		
	}
}
