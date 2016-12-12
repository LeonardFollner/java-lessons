import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

	//Attributes
	private List<Book> books = new ArrayList<>();
	private Map<Long, Book> booksMap = new HashMap<>();

	public static void main(String[] args) {

		Library library = new Library();
		Book myBook = new Book(9781558005686L, "The Hitchhiker's Guide to the Galaxy");

		System.out.println(myBook.getTitle());
		System.out.println(myBook.getIsbn());

		//geh durch alle Bücher
		for(int i = 0; i < 10; i++) {
			Long isbn = 2340837420L * i % 1000000000;
			library.getBooks().add(new Book(isbn, "My book: "  + i, "Your mama", 3));
			library.getBooksMap().put(isbn, new Book(isbn, "My book: "  + i, "Your mama", 3));
		}

		library.listAllBooks();

		// NEW
		System.out.println("Borrowed book? : " + library.getBooks().get(0).borrow());
		System.out.println("Borrowed book? : " + library.getBooks().get(0).borrow());
		System.out.println("Borrowed book? : " + library.getBooks().get(0).borrow());
		System.out.println("Borrowed book? : " + library.getBooks().get(0).borrow());
		library.getBooks().get(0).bringBack();
		System.out.println("Borrowed book? : " + library.getBooks().get(0).borrow());

	}

	public Map<Long, Book> getBooksMap() {
		return booksMap;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	private void listAllBooks() {
		for(int i = 0; i < 10; i++) {
			Book currentBook = this.books.get(i);

			if (currentBook == null) {
				continue;
			}

			System.out.println("ISBN: " + currentBook.getIsbn());
			System.out.println("Title: " + currentBook.getTitle());
			System.out.println("Author: " + currentBook.getAuthor());
			System.out.println("-----------------------------");
		}
	}
}
