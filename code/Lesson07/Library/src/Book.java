public class Book {
	//Attributes
	private long isbn;
	private String title;
	private String author;
	private int stock;

	//Constructor with 2 params
	public Book(long isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	//Constructor with 3 params
	public Book(long isbn, String title, String author, int stock) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.stock = stock;
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

	public boolean borrow() {
		if (stock > 0) {
			stock--;
			return true;
		}

		return false;
	}

	public void bringBack() {
		stock++;
	}
}
