package oneil.marcel;

import java.util.ArrayList;

/**
 * Contains information about each book
 * 
 * @author marcel
 */
public class Book implements Comparable<Object> {
	private String title;
	private String author;
	private long isbn;
	private double rating;
	private ArrayList<Review> reviews;

	/**
	 * Book constructor
	 * 
	 * @param title
	 *            Title of the book
	 * @param author
	 *            Author of the book
	 * @param isbn
	 *            ISBN of the book (number)
	 * @param reviews
	 *            List of reviews about the book
	 */
	public Book(String title, String author, long isbn, ArrayList<Review> reviews) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.reviews = reviews;
		updateRating();
	}

	/**
	 * Book constructor for reading from CSV file
	 * 
	 * @param inData
	 *            CSV file (title,author,ISBN,reviews)
	 */
	public Book(String inData) {
		String[] values = inData.split(",");
		this.title = values[0];
		this.author = values[1];
		this.isbn = Long.parseLong(values[2]);
		this.reviews = new ArrayList<Review>();
		for (int i = 3; i < values.length; i += 3)
			this.reviews.add(new Review(values[i], Integer.parseInt(values[i + 1]), values[i + 2]));
		updateRating();
	}

	/**
	 * Get title of the book
	 * 
	 * @return Title of the book
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Get author of the book
	 * 
	 * @return Author of the book
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Get ISBN of the book
	 * 
	 * @return ISBN of the book
	 */
	public long getISBN() {
		return this.isbn;
	}

	/**
	 * Get average rating of the book
	 * 
	 * @return Average rating of the book
	 */
	public double getAverageRating() {
		return this.rating;
	}
	
	/**
	 * Get ArrayList of Review objects for the book
	 * @return ArrayList of Review objects
	 */
	public ArrayList<Review> getReviews() {
		return this.reviews;
	}

	/**
	 * Adds a review to the book and updates the average rating
	 * 
	 * @param review
	 *            Review object that is added to the book
	 */
	public void addReview(Review review) {
		this.reviews.add(review);
		updateRating();
	}

	/**
	 * Updates the average rating of the book
	 */
	private void updateRating() {
		double rating = 0;
		for (Review review : this.reviews) {
			rating += review.getRating();
		}
		rating /= this.reviews.size();
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("ISBN: %-10s Author: %-20s Title: %s", this.isbn, this.author, this.title);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			if (this.isbn == book.getISBN())
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object book) {
		return Long.compare(this.isbn, ((Book) book).getISBN());
	}
}
