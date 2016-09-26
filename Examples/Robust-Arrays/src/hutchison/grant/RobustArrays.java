package hutchison.grant;

import java.text.NumberFormat;

import java.util.Arrays;
import java.util.Scanner;

public class RobustArrays {
	final static double TAX_RATE = 0.13;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Robust input demo
		NumberFormat currOut = NumberFormat.getCurrencyInstance();
		String prompt = "How much is the item in CDN dollars? ";

		double price = getDouble(in, prompt);

		double afterTaxPrice = price + (price * TAX_RATE);
		System.out.println("After tax price is " + currOut.format(afterTaxPrice));

		// Robust array setup and use
		System.out.println("How many subjects are you taking?");
		int numMarks = in.nextInt();
		int[] marks = new int[numMarks];

		// Collect the marks in a data structure
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Mark " + (i + 1) + ":");
			marks[i] = in.nextInt();
		}

		// keep a copy of the original order of marks
		int[] originalMarks = Arrays.copyOf(marks, marks.length);

		if (marks.length > 0) {
			System.out.printf("Mean mark is %.1f\n", calculateMean(marks));
			System.out.printf("Median mark is %.1f\n", calculateMedian(marks));

			System.out.println("Marks in original order");
			displayIntegers(originalMarks);

			Arrays.sort(marks);

			System.out.println("Marks in sorted order");
			displayIntegers(marks);
		} else {
			System.out.println("You didn't provide any data.");
		}

		in.close();

	}

	/**
	 * Determine the median mark from a fixed size array. precondition - marks
	 * must contain at least 1 element
	 * 
	 * @param marks
	 *            array of marks
	 * @return double median mark from a set
	 */
	private static double calculateMedian(int[] marks) {

		int numMarks = marks.length;
		boolean isEven = (numMarks % 2 == 0);

		// must sort the marks
		Arrays.sort(marks);

		if (isEven) {
			return ((marks[numMarks / 2 - 1] + marks[numMarks / 2]) / 2.0);
		} else {
			return (marks[numMarks / 2]);
		}

	}

	/**
	 * Determine the arithmetic mean (average) of a set of integers.
	 * precondition - array must contain at least 1 element
	 * 
	 * @param marks
	 *            array of integers
	 * @return mean (double)
	 */
	private static double calculateMean(int[] marks) {
		double sum = 0.0;
		for (int mark : marks) {
			sum += mark;
		}
		return sum / marks.length;
	}

	/**
	 * Displays the numbers of an array of integers in a single line of output.
	 * 
	 * @param numbers
	 *            integer array
	 */
	private static void displayIntegers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			if (i != numbers.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	/**
	 * Robust method to obtain a double value that is positive.
	 * 
	 * @param in
	 *            open Scanner object
	 * @param prompt
	 *            String text to display to user
	 * @return valid positive value (double)
	 */
	private static double getDouble(Scanner in, String prompt) {
		boolean valid = false;
		double price = 0.0;
		while (!valid) {
			System.out.print(prompt);
			if (in.hasNextDouble()) {
				price = in.nextDouble();
				if (price < 0) {
					System.out.println("The value cannot be negative.");
					in.nextLine();
				} else {
					valid = true;
				}

			} else {
				in.nextLine(); // clear the buffer
				System.out.println("You did not provide a valid numeric value. Try again");
			}
		}
		return price;
	}

}
