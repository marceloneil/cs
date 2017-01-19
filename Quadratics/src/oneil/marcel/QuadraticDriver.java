package oneil.marcel;

import java.util.Scanner;

public class QuadraticDriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("a: ");
		int a = s.nextInt();
		System.out.print("b: ");
		int b = s.nextInt();
		System.out.print("c: ");
		int c = s.nextInt();
		s.close();
		
		int d = b*b - 4*a*c;
		
		if(d > 0){
			System.out.println("There are 2 roots.");
			System.out.printf("root = %.3f\n", (float) ((-b + Math.sqrt(d)) / 2*a));
			System.out.printf("root = %.3f\n", (float) ((-b - Math.sqrt(d)) / 2*a));
		} else if(d == 0){
			System.out.println("There is one root.");
			System.out.printf("root = %.3f\n", (float) (-b / 2*a));
		} else {
			System.out.println("There is no root.");
		}
	}

}
