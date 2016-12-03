package oneil.marcel;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main driver for the program
 * 
 * @author marcel
 */
public class Driver {
	private static BookShelf wishlist = new BookShelf();
	private static BookShelf purchaselist = new BookShelf();
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		if (readBoolean("Import wish list from file? (y/n): ")) {
			loadWishList(readString("Input the name of the file: "));
		}

		boolean quit = false;
		while (!quit) {
			int command = menu();
			switch (command) {
			case 1:
				displayBooks(wishlist);
				break;
			case 2:
				addBook();
				break;
			case 3:
				rateBook();
				break;
			case 4:
				purchaseBook();
				break;
			case 5:
				displayBooks(purchaselist);
				break;
			case 6:
				exportWishList();
				quit = true;
				break;
			}
		}

		s.close();
	}

	/**
	 * Loads wish list from file
	 * 
	 * @param filename
	 *            The name of the file in the main directory of the project
	 */
	private static void loadWishList(String filename) {
		try {
			File wishlistFile = new File(filename);
			Scanner inData;
			inData = new Scanner(wishlistFile);
			inData.nextLine();
			while (inData.hasNextLine()) {
				wishlist.add(new Book(inData.nextLine()));
			}
			inData.close();
		} catch (FileNotFoundException e) {
			System.out.println("There was an issue importing the wish list");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Gets response from the user based on a number of prompts
	 * 
	 * @return Response number from the user (1-6)
	 */
	private static int menu() {
		System.out.println();
		System.out.println("*****************MENU*****************");
		System.out.println("1 - Display wish list");
		System.out.println("2 - Add a book to the wish list");
		System.out.println("3 - Review a book on the wish list");
		System.out.println("4 - Purchase a book from the wish list");
		System.out.println("5 - Display purchased books");
		System.out.println("6 - Quit");
		int response = readInt("Please input a command: ", 1, 6);
		System.out.println();
		return response;
	}

	/**
	 * Displays a list of books to the user
	 */
	private static void displayBooks(BookShelf list) {
		System.out.println("There are " + list.getNumBooks() + " books in this list");
		list.sort();
		for (Book book : list.getBooks()) {
			System.out.println(book.toString());
		}
	}

	/**
	 * Adds a Book object to the wish list
	 */
	private static void addBook() {
		String title = readString("Input the title: ");
		String author = readString("Input the author: ");
		long isbn = readLong("Input the ISBN: ");
		wishlist.add(new Book(title, author, isbn, new ArrayList<Review>()));
	}

	/**
	 * Adds a review to a Book object in the wish list
	 */
	private static void rateBook() {
		wishlist.sort();
		for (int i = 0; i < wishlist.getNumBooks(); i++) {
			System.out.println((i + 1) + " - " + wishlist.getBook(i).getTitle());
		}
		int index = readInt("Please enter the book number you wish to rate: ", 1, wishlist.getNumBooks() + 1) - 1;
		String commenter = readString("Please enter the name of the commenter: ");
		int rating = readInt("Please enter the rating (1-5): ", 1, 5);
		String comment = readString("Please enter your comment: ");
		wishlist.getBook(index).addReview(new Review(commenter, rating, comment));
	}

	/**
	 * Removes a Book object from the wish list and adds it to the purchase list
	 */
	private static void purchaseBook() {
		wishlist.sort();
		for (int i = 0; i < wishlist.getNumBooks(); i++) {
			Book book = wishlist.getBook(i);
			if (!Double.isNaN(book.getAverageRating()))
				System.out.println((i + 1) + " - " + book.getTitle() + " (" + book.getAverageRating() + ")");
			else
				System.out.println((i + 1) + " - " + book.getTitle() + " (No Rating)");
		}
		int index = readInt("Please enter the book number you wish to purchase: ", 1, wishlist.getNumBooks() + 1) - 1;
		Book book = wishlist.getBook(index);
		purchaselist.add(book);
		wishlist.remove(book);
	}

	/**
	 * Export the wish list to a file
	 */
	private static void exportWishList() {
		if (readBoolean("Export wish list to file? (y/n): ")) {
			try {
				String filename = readString("Input the name of the file: ");
				File file = new File(filename);
				FileWriter fileWriter;
				fileWriter = new FileWriter(file);
				fileWriter.write("Title,Author,ISBN,Review\n");
				for (Book book : wishlist.getBooks()) {
					fileWriter.write(formatCSV(book));
				}
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("There was an issue exporting the wish list");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Format a Book object into a line of CSV
	 * @param book Book object to convert
	 * @return CSV line
	 */
	private static String formatCSV(Book book) {
		String csv = book.getTitle() + "," + book.getAuthor() + "," + book.getISBN();
		for (Review review : book.getReviews()) {
			csv += "," + review.getCommenter() + "," + review.getRating() + "," + review.getComment();
		}
		csv += "\n";
		return csv;
	}

	/**
	 * Reads a string from the user
	 * 
	 * @param prompt
	 *            Prompt for the user to read
	 * @return The user's input
	 */
	private static String readString(String prompt) {
		String input = null;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid option: " : prompt);
			if (s.hasNextLine()) {
				invalid = false;
				input = s.nextLine();
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		return input;
	}

	/**
	 * Reads a boolean from the user
	 * 
	 * @param prompt
	 *            Prompt for the user to read
	 * @return The user's input
	 */
	private static boolean readBoolean(String prompt) {
		boolean input = false;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid character: " : prompt);
			if (s.hasNextLine()) {
				char[] chars = s.nextLine().toCharArray();
				char inputChar = Character.toLowerCase(chars[0]);
				if (chars.length == 1 && (inputChar == 'y' || inputChar == 'n')) {
					invalid = false;
					if (inputChar == 'y')
						input = true;
					else
						input = false;
				} else {
					invalid = true;
				}
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		return input;
	}

	/**
	 * Reads an integer from the user
	 * 
	 * @param prompt
	 *            Prompt for the user to read
	 * @param min
	 *            Minimum integer for the user to input
	 * @param max
	 *            Maximum integer for the user to input
	 * @return The user's input
	 */
	private static int readInt(String prompt, int min, int max) {
		int input = 0;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid integer (" + min + "-" + max + "): " : prompt);
			if (s.hasNextLine()) {
				if (s.hasNextInt()) {
					input = s.nextInt();
					if (input < min || input > max) {
						invalid = true;
					} else {
						invalid = false;
					}
				} else {
					invalid = true;
				}
				s.nextLine();
			} else {
				invalid = true;
			}
		} while (invalid);
		return input;
	}

	/**
	 * Reads a long from the user
	 * 
	 * @param prompt
	 *            Prompt for the user to read
	 * @return The user's input
	 */
	private static long readLong(String prompt) {
		long input = 0;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid positive integer: " : prompt);
			if (s.hasNextLine()) {
				if (s.hasNextLong()) {
					input = s.nextLong();
					if (input < 0) {
						invalid = true;
					} else {
						invalid = false;
					}
				} else {
					invalid = true;
				}
				s.nextLine();
			}
		} while (invalid);
		return input;
	}

}
