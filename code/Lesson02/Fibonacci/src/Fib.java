public class Fib {

	private void fib() {
		int fib1 = 1;
		int fib2 = 1;

		System.out.println(fib1);
		System.out.println(fib2);

		for(int counter = 1; counter <= 15; counter++) {

			System.out.println(fib1 + fib2);
			fib1 = fib2;
			fib2 = fib1 + fib2;
		}
	}
}
