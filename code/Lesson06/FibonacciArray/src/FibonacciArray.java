import java.util.Arrays;

/**
 * Created by Max on 28.11.16.
 */
public class FibonacciArray {

    Integer[] fibonacci = new Integer[0];

    public void add(Integer i) throws NoFibonacciException {
        int fib1 = 1;
        int fib2 = 1;
        boolean found = false;

        for(int counter = 1; counter <= 100; counter++) {
            int next = fib2;
            fib2 = fib1 + fib2;
            fib1 = next;

            if (fib1 == i) {
                int length = fibonacci.length;
                fibonacci = Arrays.copyOf(fibonacci, length + 1);
                fibonacci[length] = i;
                found = true;
                break;
            }
        }

        if (found == false) {
            throw new NoFibonacciException();
        }
    }

}
