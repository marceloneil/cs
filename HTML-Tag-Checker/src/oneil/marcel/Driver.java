package oneil.marcel;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Provide a valid HTML tag statement: ");
		String tag = s.nextLine();
		s.close();

		if (validateTag(tag)) {
			System.out.println("Match");
			System.out.println("Tag was: " + getTagType(tag));
			System.out.println("Data was: " + getTagContent(tag));
		} else {
			System.out.println("No Match");
		}

	}

	private static boolean validateTag(String tag) {
		if (tag.indexOf('<') != 0 || tag.indexOf('>', tag.indexOf('<') + 1) < 0
				|| tag.indexOf("</", tag.indexOf('>') + 1) < 0 || tag.indexOf('>', tag.indexOf("</") + 1) < 0)
			return false;
		if (getTagType(tag) != tag.substring(tag.indexOf("</") + 1, tag.indexOf('>', tag.indexOf("</") + 1)))
			return false;
		return true;
	}

	private static String getTagType(String tag) {
		return tag.substring(tag.indexOf('<') + 1, tag.indexOf('>'));
	}

	private static String getTagContent(String tag) {
		return tag.substring(tag.indexOf('>') + 1, tag.indexOf("</"));
	}

}
