package oneil.marcel;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3PascalDriver {

	public static void main(String[] args) {
		// Ask the user how many rows they would like to create of Pascal's
		// triangle
		// Valid responses are 1-20
		// https://en.wikipedia.org/wiki/Pascal's_triangle

		// The values are integers, but it is not a fixed 2D array so a List of
		// Lists is best

		final int MIN = 1;
		final int MAX = 20;

		Scanner in = new Scanner(System.in);
		String prompt = "How many rows? (1-20) :";
		int rows = getInt(in, prompt, MIN, MAX);

		// Declare the initial list of lists
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			triangle.add(new ArrayList<Integer>());
		}

		generateTriangle(triangle);
		displayTriangle(triangle);

	}

	private static void displayTriangle(ArrayList<ArrayList<Integer>> triangle) {
		for (ArrayList<Integer> row : triangle) {
			for (Integer column : row) {
				System.out.print(column + " ");
			}
			System.out.println();
		}
	}

	private static void generateTriangle(ArrayList<ArrayList<Integer>> triangle) {
		int count = 1;
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < count; j++) {
				if (j == 0 || j == triangle.get(i - 1).size()) {
					triangle.get(i).add(1);
				} else {
					triangle.get(i).add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
				}
			}
			count ++;
		}
	}

	private static int getInt(Scanner in, String prompt, int min, int max) {
		boolean valid = false;
		int value = 0;
		System.out.print(prompt);
		while (!valid && in.hasNextLine()) {
			if (in.hasNextInt()) {
				value = in.nextInt();
				if (value >= min && value <= max) {
					valid = true;
				} else {
					System.out.printf("Value must be between %d and %d.\n", min, max);
				}
			} else {
				System.out.printf("Value must be numeric and between %d and %d.\n", min, max);
				in.next();
			}
			if (!valid) {
				System.out.print(prompt);
			}
		}
		return value;
	}
}
