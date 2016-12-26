package oneil.marcel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SortDriver {
	public enum SortType {
		SELECTION, INSERTION, MERGE, QUICK
	}

	public enum TimeType {
		MILLI, NANO
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean quit = false;
		do {
			int selection = menu(s);
			if (selection <= 4) {
				int listLength = readInt(s, "How many integer values would you like to sort? ");
				int[] list = createList(listLength);
				switch (selection) {
				case 1:
					printInfo(list, timeSort(list, SortType.SELECTION, TimeType.MILLI));
					break;
				case 2:
					printInfo(list, timeSort(list, SortType.INSERTION, TimeType.MILLI));
					break;
				case 3:
					printInfo(list, timeSort(list, SortType.MERGE, TimeType.MILLI));
					break;
				case 4:
					printInfo(list, timeSort(list, SortType.QUICK, TimeType.MILLI));
					break;
				}
			} else if (selection == 5) {
				try {
					File file = new File("sortdata.csv");
					FileWriter out = new FileWriter(file);
					int[] listLengths = { 5000, 10000, 20000, 40000, 80000, 100000 };
					SortType[] sortTypes = { SortType.SELECTION, SortType.INSERTION, SortType.MERGE, SortType.QUICK };
					out.write("# of Items,Selection,Insertion,Merge,Quick\n");
					for (int length : listLengths) {
						out.write(length + "");
						for (SortType sort : sortTypes) {
							int[] list = createList(length);
							long totalTime = timeSort(list, sort, TimeType.NANO);
							out.write("," + totalTime);
						}
						out.write("\n");
					}
					out.close();
					System.out.println("Data was generated in file sortdata.csv");
					System.out.println();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else {
				quit = true;
			}
		} while (!quit);
		s.close();
	}
	
	/*
	 * 	*****Selection Sort Data*****
	 * 	
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

	public static int menu(Scanner s) {
		System.out.println("*******MENU*******");
		System.out.println("1: Selection Sort");
		System.out.println("2: Insertion Sort");
		System.out.println("3: Merge Sort");
		System.out.println("4: Quick Sort");
		System.out.println("5: Compare Sorts");
		System.out.println("6: Quit");

		int input = 6;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid command: " : "Please select a command: ");
			if (s.hasNextInt()) {
				input = s.nextInt();
				if (input < 1 || input > 6) {
					invalid = true;
					s.nextLine();
				} else {
					invalid = false;
					s.nextLine();
				}
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		System.out.println();
		return input;
	}

	private static int[] createList(int listLength) {
		int[] list = new int[listLength];
		for (int i = 0; i < listLength; i++) {
			list[i] = (int) (Math.random() * Integer.MAX_VALUE + 1);
		}
		return list;
	}

	private static long timeSort(int[] list, SortType sort, TimeType time) {
		long startTime;
		long endTime;
		if (time == TimeType.MILLI)
			startTime = System.currentTimeMillis();
		else
			startTime = System.nanoTime();
		switch (sort) {
		case SELECTION:
			Sorts.selectionSort(list);
			break;
		case INSERTION:
			Sorts.insertionSort(list);
			break;
		case MERGE:
			Sorts.mergeSort(list, new int[list.length], 0, list.length - 1);
			break;
		case QUICK:
			Sorts.quicksort(list, 0, list.length);
			break;
		}
		if (time == TimeType.MILLI)
			endTime = System.currentTimeMillis();
		else
			endTime = System.nanoTime();
		return endTime - startTime;
	}

	private static void printInfo(int[] list, long time) {
		System.out.println("Smallest Value: " + list[0]);
		System.out.println("Largest Value: " + list[list.length - 1]);
		System.out.println("Total Sorting Time (ms): " + time);
		System.out.println();
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
