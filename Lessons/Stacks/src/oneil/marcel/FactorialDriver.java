package oneil.marcel;

import java.util.*;
import java.math.*;
import java.util.concurrent.TimeUnit;

public class FactorialDriver {
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Which factorial would you like? ");
		int n = in.nextInt();
		in.nextLine();
		
		System.out.println("Recursive version");
		long startTime = System.nanoTime();
		long ans = factorialRecursive(n);
		long stopTime = System.nanoTime();
		System.out.println("" + n + "!=" + (ans) + "\nTime was " + (stopTime - startTime)+ " ns");

		System.out.println("Iterative version");
		startTime = System.nanoTime();
		ans = factorialIterative(n);
		stopTime = System.nanoTime();
		System.out.println("" + n + "!=" + (ans) + "\nTime was " + (stopTime - startTime)+ " ns");
		
		System.out.println("If you want to go higher than 23! use BigInteger" );
		System.out.print("Which factorial would you like to try now?");
		BigInteger bigNum = new BigInteger(in.nextLine().trim());
		
		startTime = System.nanoTime();
		BigInteger ansNum = BigInteger.ONE;
		startTime = System.nanoTime();
		ansNum = factorialRecursiveBig(bigNum);
		stopTime = System.nanoTime();
		
		System.out.println("Recursive version with BigIntegers");		
		System.out.println(ansNum);
		System.out.println("Time was " + (stopTime-startTime) + " ns");
		
		in.close();

	}

	private static BigInteger factorialRecursiveBig (BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else {
			return factorialRecursiveBig(n.subtract(BigInteger.ONE)).multiply(n);
		}
	}

	private static long factorialRecursive(long n) {
		if (n == 0)
			return 1;
		else {
			return factorialRecursive(n - 1) * n;
		}
	}

	private static long factorialIterative(long n) {
		long result = n;
		if (n == 0)
			return 1;

		for (long i = n - 1; i > 0; i--) {
			result = result * i;
		}
		return result;
	}

}
