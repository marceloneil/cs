package oneil.marcel;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int numPrimes = readInt(s, "Input the amount of primes desired: ");
		s.close();

		int[] primes = findPrimes(numPrimes);
		displayIntegers(primes);
	}
	
	private static int[] findPrimes(int numPrimes){
		int[] primes = new int[numPrimes];
		int primeIndex = 0;
		int counter = 2;

		while (primeIndex < numPrimes) {
			if (isPrime(counter)) {
				primes[primeIndex] = counter;
				primeIndex++;
			}
			counter++;
		}
		
		return primes;
	}

	private static boolean isPrime(int num) {
		if (num == 2)
			return true;
		if (num <= 1)
			return false;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

	private static void displayIntegers(int[] numbers) {
		for (int number : numbers) {
			System.out.println(number);
		}
	}

	private static int readInt(Scanner s, String prompt) {
		int input = 0;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid positive integer: " : prompt);
			if (s.hasNextInt()) {
				input = s.nextInt();
				if (input < 0) {
					invalid = true;
					s.nextLine();
				} else {
					invalid = false;
				}
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		return input;
	}
}
