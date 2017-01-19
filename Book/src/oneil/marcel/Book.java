package oneil.marcel;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private String content;
	private double price;

	public Book(String title, String author, String content, double price) {
		this.title = title;
		this.author = author;
		this.content = content;
		this.price = price;
	}

	public Book(String title, String author, String publisher, String content, double price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.content = content;
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		if (this.publisher != null)
			return title + "\nBy: " + author + "\n" + "Publisher: " + publisher + "\n" + "Price: " + price + "\n\n"
					+ content;
		return title + "\nBy: " + author + "\n" + "Price: " + price + "\n\n" + content;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			if (this.title.equals(book.getTitle()) && this.author.equals(book.getAuthor()))
				return true;
		}
		return false;
	}
}
