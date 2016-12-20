package oneil.marcel;

import java.util.*;

public class TODOStacks {

	public static void main(String[] args) {
		Stack<Integer> nums = new Stack<>();

		Scanner in = new Scanner(System.in);
		System.out.println("Type a 5 numbers (eg. 1 2 3 4 5): ");
		for (int i = 0; i < 5; i++) {
			nums.push(in.nextInt());
		}

		System.out.println("The stack has " + nums.size() + " items.");
		System.out.println("Here are all of the items.");

		while (!nums.isEmpty()) {
			System.out.print(nums.pop() + " ");
		}
		System.out.println();

		System.out.print("Type a single integer number: ");
		int n = in.nextInt();
		in.nextLine();

//		while (n > 0) {
//			nums.push(n % 2);
//			n = n / 2;
//		}
//		
//		while (!nums.isEmpty())
//			System.out.print(nums.pop());
//		System.out.println();
		
		while (n > 0) {
			nums.push(n % 16);
			n = n / 16;
		}
		
		while (!nums.isEmpty())
			System.out.print(Integer.toHexString(nums.pop()));
		System.out.println();
		
		// TODO implement a version that handles hexadecimal numbers
	}

}
