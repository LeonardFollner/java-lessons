public class Calc {
  public static void main(String[] args) {
    float celsius1 = 20;
    float celsius2 = 40;
    float celsius3 = 120;

    float fahrenheit1 = celsius1 * 1.8f + 32f;
    float fahrenheit2 = celsius2 * 1.8f + 32f;
    float fahrenheit3 = celsius3 * 1.8f + 32f;

    System.out.println(fahrenheit1);
    System.out.println(fahrenheit2);
    System.out.println(fahrenheit3);
  }
}
