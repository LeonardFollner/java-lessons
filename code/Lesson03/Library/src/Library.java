public class Library {

	//Attributes
	private static Book[][] myLibrary = new Book[10][100];

	public static void main(String[] args) {

		Book myBook = new Book(9781558005686L, "The Hitchhiker's Guide to the Galaxy");

		System.out.println(myBook.getTitle());
		System.out.println(myBook.getIsbn());

		//geh durch alle Regale
		for(int i = 0; i < 10; i++) {
			//geh durch alle Buecher
			for(int j = 0; j < 50; j++) {

				myLibrary[i][j] = new Book((i + j), "My book in shelf " + i + " no. " + j, "Your mama");
			}
		}

		listAllBooks();
	}

	private static void listAllBooks() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 100; j++) {
				Book currentBook = myLibrary[i][j];

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
}
