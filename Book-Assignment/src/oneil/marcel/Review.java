package oneil.marcel;

/**
 * Review of a Book Object
 * 
 * @author marcel
 */
public class Review {
	private String commenter;
	private int rating;
	private String comment;

	/**
	 * Review constructor
	 * 
	 * @param commenter
	 *            Name of individual who created the review
	 * @param rating
	 *            Integer from 1-5 rating the Book
	 * @param comment
	 *            A short description of the rating
	 */
	public Review(String commenter, int rating, String comment) {
		this.commenter = commenter;
		this.rating = rating;
		this.comment = comment;
	}

	/**
	 * Gets the name of the commenter for the Review
	 * 
	 * @return Name of individual who created the review
	 */
	public String getCommenter() {
		return this.commenter;
	}

	/**
	 * Gets the rating number for the Review
	 * 
	 * @return Integer from 1-5 rating the Book
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * Gets the comment for the Review
	 * 
	 * @return A short description of the rating
	 */
	public String getComment() {
		return this.comment;
	}

	@Override
	public String toString() {
		return this.commenter + " - " + rating + "/5\n\n" + comment;
	}
}
