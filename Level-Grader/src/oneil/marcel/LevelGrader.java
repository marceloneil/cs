package oneil.marcel;

import java.util.Scanner;

public class LevelGrader {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter your mark (Percentage): ");
		int mark = s.nextInt();
		s.close();
		char level;
		switch ((int) mark / 10) {
		case 9: // 90-99: 5
			level = '5';
			break;
		case 8: // 80-89: 4
			level = '4';
			break;
		case 7: // 70-79: 3
			level = '3';
			break;
		case 6: // 60-69: 2
			level = '2';
			break;
		case 5: // 50-59: 1
			level = '1';
			break;
		default: // <50: R
			level = 'R';
			break;
		}

		System.out.println("Your level is: " + level);

	}

}
