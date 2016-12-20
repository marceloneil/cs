package oneil.marcel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SortDriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int listLength = readInt(s, "How many integer values would you like to sort? (-1 for all sizes): ");
		if (listLength != -1) {
			int[] list = createList(listLength);
			long totalTime = timeSort(list);
			System.out.println("Smallest Value: " + list[0]);
			System.out.println("Largest Value: " + list[listLength - 1]);
			System.out.println("Total Sorting Time (ms): " + totalTime);
		} else {
			try {
				File file = new File("sortdata.csv");
				FileWriter out = new FileWriter(file);
				int[] listLengths = { 5000, 10000, 20000, 40000, 80000, 100000 };
				for (int length : listLengths) {
					int[] list = createList(length);
					long totalTime = timeSort(list);
					out.write(length + "," + totalTime + "\n");
				}
				out.close();
				System.out.println("Data was generated in file sortdata.csv");
				/*
				 * 	sortdata.csv
				 * 	
				 * 	+------------+--------------+
				 * 	| # of Items | Milliseconds |
				 * 	+------------+--------------+
				 * 	|       5000 |           26 |
				 * 	|      10000 |           38 |
				 * 	|      20000 |          141 |
				 * 	|      40000 |          537 |
				 * 	|      80000 |         2094 |
				 * 	|     100000 |         3221 |
				 * 	+------------+--------------+
				 * 
				 * 
				 * 	Trendline (using gnuplot)
				 * 	For f(x) = a*x**2 + b*x + c
				 * 
				 * 	Final set of parameters            Asymptotic Standard Error
				 * 	=======================            ==========================
				 * 	a               = 3.13281e-07      +/- 5.94e-09     (1.896%)
				 * 	b               = 0.000919426      +/- 0.00063      (68.52%)
				 * 	c               = 3.16963          +/- 10.68        (337.1%)
				 * 
				 * 
				 * 	For x = 150000
				 * 	
				 * 	Theoretical value: 7190
				 * 	Experimental value: 7236
				 * 
				 * 	Error: ~0.64%
				 */
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			s.close();
		}
	}

	private static int[] createList(int listLength) {
		int[] list = new int[listLength];
		for (int i = 0; i < listLength; i++) {
			list[i] = (int) (Math.random() * Integer.MAX_VALUE + 1);
		}
		return list;
	}

	private static long timeSort(int[] list) {
		long startTime = System.currentTimeMillis();
		// Sorts.selectionSort(list);
		 Sorts.insertionSort(list);
		// Sorts.mergeSort(list, new int[list.length], 0, list.length-1);
		// Sorts.quicksort(list, 0, list.length);
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	private static int readInt(Scanner s, String prompt) {
		int input = 0;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid positive integer: " : prompt);
			if (s.hasNextLine()) {
				if (s.hasNextInt()) {
					input = s.nextInt();
					if (input > 0 || input == -1)
						invalid = false;
					else
						invalid = true;
				} else {
					invalid = true;
				}
			} else {
				invalid = true;
			}
			s.nextLine(); // consume remaining tokens
		} while (invalid);
		return input;

	}

}
