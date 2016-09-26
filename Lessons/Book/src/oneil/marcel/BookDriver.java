package oneil.marcel;

public class BookDriver {

	public static void main(String[] args) {
		Book book1 = new Book(
				"Book One",
				"Marcel O'Neil",
				"This is book number one\n"
				+ "and it has multiple\n"
				+ "lines to read",
				10.99);
		
		Book book2 = new Book(
				"Book Two",
				"Marcel O'Neil",
				"This is book number two\n"
				+ "and it has multiple\n"
				+ "lines to read",
				10.99);
		
		Book book3 = new Book(
				"Book One",
				"Marcel O'Neil",
				"Publishing Company",
				"This is book number one\n"
				+ "and it has multiple\n"
				+ "lines to read",
				10.99);
		
		// Print out the books
		System.out.println(book1.toString() + "\n");
		System.out.println(book2.toString() + "\n");
		System.out.println(book3.toString() + "\n");
		
		// Check equality of books
		System.out.println("book1 equals book2: " + book1.equals(book2));
		System.out.println("book2 equals book3: " + book2.equals(book3));
		System.out.println("book1 equals book3: " + book1.equals(book3));
	}

}
