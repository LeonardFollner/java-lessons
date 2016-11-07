public class Book {
	//Attributes
		private long isbn;
		private String title;

	//Constructor
	public Book(long isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	//Methods
	public String getTitle() {
		return title;
	}

	public long getIsbn() {
		return isbn;
	}

}
