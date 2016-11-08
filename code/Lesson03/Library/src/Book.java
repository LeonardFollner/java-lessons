public class Book {
	//Attributes
	private long isbn;
	private String title;
	private String author;

	//Constructor with 2 params
	public Book(long isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	//Constructor with 3 params
	public Book(long isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	//Methods
	public String getTitle() {
		return title;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getAuthor() {
		return author;
	}

}
