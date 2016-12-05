public class Circle implements TwoDimensional{
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius*radius*TwoDimensional.pi;
    }

    public double getPerimeter() {
        return 2*TwoDimensional.pi*radius;
    }
}
