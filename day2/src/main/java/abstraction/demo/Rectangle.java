package abstraction.demo;

public class Rectangle extends Shape {
    private final double WIDTH, LENGTH; //sides
    public Rectangle() {
        this(1,1);
    }
    /**
     * 
     * @param width - the width of the rectangle
     * @param length - the length of the rectangle
     */
    public Rectangle(double width, double length) {
        this.WIDTH = width;
        this.LENGTH = length;
    }
    public double area() {
        // A = w * l
        return WIDTH * LENGTH;
    }
    public double perimeter() {
        // P = 2(w + l)
        return 2 * (WIDTH + LENGTH);
    }
}