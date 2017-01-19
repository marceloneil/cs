package oneil.marcel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains an array of book objects
 * 
 * @author marcel
 */
public class BookShelf {
	private ArrayList<Book> books;

	/**
	 * Constructor for BookShelf (Creates and empty bookshelf)
	 */
	public BookShelf() {
		this.books = new ArrayList<Book>();
	}

	/**
	 * Constructor for BookShelf
	 * 
	 * @param books
	 *            ArrayList of Book objects to add to BookShelf
	 */
	public BookShelf(ArrayList<Book> books) {
		this.books = books;
	}

	/**
	 * Add a Book to the BookShelf
	 * 
	 * @param book
	 *            Book object to add to BookShelf
	 */
	public void add(Book book) {
		books.add(book);
	}

	/**
	 * Removes a Book from the BookShelf
	 * 
	 * @param book
	 *            Book object to remove from BookShelf
	 */
	public void remove(Book book) {
		books.remove(book);
	}

	/**
	 * Sorts Book object in order from low to high ISBN number
	 */
	public void sort() {
		Collections.sort(books);
	}

	/**
	 * Get a single Book object from the BookShelf
	 * 
	 * @param index
	 *            Index of the Book Object in the BookShelf
	 * @return Book Object that was requested
	 */
	public Book getBook(int index) {
		return this.books.get(index);
	}

	/**
	 * Get all Book objects from the BookShelf
	 * 
	 * @return An ArrayList of Book objects
	 */
	public ArrayList<Book> getBooks() {
		return this.books;
	}

	/**
	 * Get number of Book objects in the BookShelf
	 * 
	 * @return The number of Books in the BookShelf
	 */
	public int getNumBooks() {
		return this.books.size();
	}

	@Override
	public String toString() {
		String string = "";
		for (Book book : books)
			string += book.toString() + "\n";
		return string;
	}

}
