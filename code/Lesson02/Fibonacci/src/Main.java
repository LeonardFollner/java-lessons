public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");

		int fib1 = 1;
		int fib2 = 1;
		int newFib;

		System.out.println(fib1);
		System.out.println(fib2);

		for(int counter = 1; counter <= 15; counter++) {
			newFib = fib1 + fib2;
			System.out.println(newFib);

			fib1 = fib2;
			fib2 = newFib;
		}
	}
}
