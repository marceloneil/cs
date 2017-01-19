package oneil.marcel;

import java.util.Scanner;
import java.util.Stack;

/**
 * This program will use a Stack data structure from the Java Collections class
 * to validate the proper nesting of brackets in a math expression. 
 * 
 */

public class TODOCheckBracket {
	
	private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Type a mathematical expression with brackets. ");
		String exp = in.nextLine().trim();
		in.close();

		if (validNestedBrackets(exp)) {
			System.out.println("The brackets are nested properly.");
		} else {
			System.out.println("The brackets are not nested properly.");
		}
	}


	private static boolean validNestedBrackets(String expression) {
		Stack<Character> nodes = new Stack<Character>();

		// convert the math expression to a character Array
		char[] tokens = expression.toCharArray();
									
		boolean isMatch = true;
		/*
		 * Use a stack to validate the nesting of brackets.
		 * Note: Ignore any non-bracket style tokens.
		 */
		
		// TODO

		return isMatch;
	}
}
