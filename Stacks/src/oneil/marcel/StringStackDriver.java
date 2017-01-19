package oneil.marcel;

import java.util.*;

public class StringStackDriver {

	public static void main(String[] args) {

		doStringStackVersion();
		doJavaStackVersion();

	}

	public static void doJavaStackVersion() {
		Scanner in = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();

		System.out.println("Type a sentence on the line below.");
		String sentenceIn = in.nextLine().trim();
		String[] words = sentenceIn.split(" ");

		for (String word : words) {
			stack.push(word);
		}

		System.out.println("The sentence backwards is on the line below.");

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		in.close();
	}

	public static void doStringStackVersion() {

		Scanner in = new Scanner(System.in);
		StringStack stack = new StringStack();

		System.out.println("Type a sentence on the line below.");
		String sentenceIn = in.nextLine().trim();
		String[] words = sentenceIn.split(" ");

		for (String word : words) {
			stack.push(word);
		}

		System.out.println("The sentence backwards is on the line below.");

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		in.close();
	}
}
