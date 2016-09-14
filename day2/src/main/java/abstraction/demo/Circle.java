/**
 * 
 */
package abstraction.demo;

/**
 * @author dragos
 *
 */
public class Circle extends Shape {

	private final double RADIUS;
	public Circle(){
		this(1.0);
	}
	public Circle(double radius) {
		this.RADIUS = radius;
	}
	@Override
	public double area() {
		return Math.pow(this.RADIUS, 2)*Math.PI;
	}
	@Override
	public double perimeter() {
		return 2.0*this.RADIUS*Math.PI;
	}

}
