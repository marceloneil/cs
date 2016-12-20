package oneil.marcel;

import java.util.*;

public class FibonacciDriver {
	

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Which Fibonacci number? ");
		int n = in.nextInt();
		System.out.println("\n**************");
		System.out.println("Iterative");
	
		long start = System.nanoTime();
		System.out.println("The number is: " + iterativeFibonacci(n));
		long finish = System.nanoTime();
		long iTime = finish - start;
		System.out.println("Time was " + iTime + " nanoseconds.");

		System.out.println("\n**************");
		System.out.println("Recursive");
		start = System.nanoTime();
		System.out.println("The number is: " + recursiveFibonacci(n));
		finish = System.nanoTime();
		long rTime = finish - start;
		System.out.println("Time was " + rTime + " nanoseconds.");

		System.out.println("Recursive was " + (int) ((double) rTime / iTime) + " times slower.");
		System.out.println("\n**************");
		System.out.println("Recursive - Dynamic Programming");
		long[] fibs = new long[n+1];
		start = System.nanoTime();
		System.out.println("The number is: " + recursiveFibDP(n,fibs));
		finish = System.nanoTime();
		rTime = finish - start;
		System.out.println("Time was " + rTime + " nanoseconds.");
	}

	private static long iterativeFibonacci(int n) {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}
		return x;
	}

	private static long recursiveFibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return recursiveFibonacci(n - 2) + recursiveFibonacci(n - 1);
		}
	}

	private static long recursiveFibDP(long n, long[] fibs) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		if (fibs[(int)n] != 0) {
			return fibs[(int)n];
		} else {
			fibs[(int)n] = recursiveFibDP((n - 1),fibs) + recursiveFibDP((n - 2),fibs);
			return fibs[(int)n];

		}
	}
}
