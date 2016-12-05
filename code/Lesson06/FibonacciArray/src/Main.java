/**
 * Created by Max on 28.11.16.
 */
public class Main {

    public static void main(String[] args) {
        FibonacciArray fiboMenge = new FibonacciArray();
        for (int i = 0; i < 100; i++) {
            try {
                fiboMenge.add(i);
                System.out.println(i);
            } catch (NoFibonacciException e) {
            }
        }

    }
}
