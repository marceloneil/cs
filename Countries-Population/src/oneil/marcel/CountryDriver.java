package oneil.marcel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

public class CountryDriver {

	public static void main(String[] args) {

		try {
			// Read Data
			File inFile = new File("countries_pop.csv");
			Scanner inData = new Scanner(inFile);
			Scanner s = new Scanner(System.in);

			ArrayList<Country> countries = new ArrayList<Country>();
			inData.nextLine();
			while (inData.hasNextLine()) {
				countries.add(new Country(inData.nextLine()));
			}
			inData.close();
			// Print out basic data

			System.out.println("There are " + countries.size() + " countries.");
			long totalPopulation = 0;
			for (Country country : countries)
				totalPopulation += country.getPopulation();
			System.out.println("The total population of the world is " + totalPopulation);
			System.out.println("The average population of a country is " + (long) totalPopulation / countries.size());
			System.out.println();
			
			boolean quit = false;
			do {
				int choice = choose(s);
				if (choice == 1) {
					char letter = readChar(s, "Please input a letter: ");
					int numCountries = searchLetter(countries, letter).size();
					if (numCountries == 1)
						System.out.println("There is 1 country that starts with the letter " + letter);
					else
						System.out.println("There are " + searchLetter(countries, letter).size()
								+ " countries that start with the letter " + letter);
					System.out.println();
				} else if (choice == 2) {
					String search = readString(s, "\nPlease input a string: ");
					ArrayList<Country> countriesQuery = searchString(countries, search);
					for (Country country : countriesQuery) {
						System.out.println(country.getName() + " has a population of " + country.getPopulation());
					}
					if (countriesQuery.size() == 0)
						System.out.println("No countries matched your search query");
					System.out.println();
				} else if (choice == 3) {
					Collections.sort(countries);
					for( Country country : countries) {
						System.out.println(country.getName() + " has a population of " + country.getPopulation());
					}
				} else if (choice == 4) {
					quit = true;
					System.out.println("Quitting...");
				}
			} while (!quit);
			s.close();
		} catch (Exception e) {
			System.out.println("A problem has occurred.");
			System.out.println(e.getMessage());
		}

	}

	public static int choose(Scanner s) {
		System.out.println("1: Number of countries that start with a specific letter");
		System.out.println("2: Country search");
		System.out.println("3: Sort countries");
		System.out.println("4: Quit");

		int input = 4;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid command: " : "Please select a command: ");
			if (s.hasNextInt()) {
				input = s.nextInt();
				if (input < 1 || input > 4) {
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

	public static ArrayList<Country> searchString(ArrayList<Country> countries, String string) {
		ArrayList<Country> matches = new ArrayList<Country>();
		for (Country country : countries) {
			if (country.getName().toLowerCase().contains(string.toLowerCase()))
				matches.add(country);
		}
		return matches;
	}

	public static long getPopulation(ArrayList<Country> countries, String string) {
		for (Country country : countries) {
			if (country.getName().equals(string))
				return country.getPopulation();
		}
		return 0;
	}

	public static ArrayList<Country> searchLetter(ArrayList<Country> countries, char letter) {
		ArrayList<Country> matches = new ArrayList<Country>();
		for (Country country : countries) {
			if (country.firstLetter() == letter)
				matches.add(country);
		}
		return matches;
	}

	private static String readString(Scanner s, String prompt) {
		String input = null;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid character: " : prompt);
			if (s.hasNextLine()) {
				invalid = false;
				input = s.nextLine();
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		return input.toLowerCase();
	}

	private static char readChar(Scanner s, String prompt) {
		char input = 'a';
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid character: " : prompt);
			if (s.hasNextLine()) {
				char[] chars = s.nextLine().toCharArray();
				int index = (int) chars[0];
				if (chars.length > 1 || index < 65 || index > 122 || (index > 90 && index < 97)) {
					invalid = true;
				} else {
					invalid = false;
					input = chars[0];
				}
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		return Character.toUpperCase(input);
	}

}
