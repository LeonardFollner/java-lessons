public class Test {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        Rectangle myRectangle = new Rectangle(2, 4);
        Square mySquare = new Square(3);

        System.out.println("circle");
        System.out.println(myCircle.getArea());
        System.out.println(myCircle.getPerimeter());
        System.out.println("rectangle");
        System.out.println(myRectangle.getArea());
        System.out.println(myRectangle.getPerimeter());
        System.out.println("square");
        System.out.println(mySquare.getArea());
        System.out.println(mySquare.getPerimeter());
    }
}
