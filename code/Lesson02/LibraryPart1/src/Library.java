public class Library {
	public static void main(String[] args) {

		Book myBook = new Book(9781558005686L, "The Hitchhiker's Guide to the Galaxy");

		System.out.println(myBook.getTitle());
		System.out.println(myBook.getIsbn());
	}
}
