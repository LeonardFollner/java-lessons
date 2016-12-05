public class Rectangle implements TwoDimensional{
    private float a;
    private float b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public double getArea() {
        return a*b;
    }

    public double getPerimeter() {
        return 2*a + 2*b;
    }
}
