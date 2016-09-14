package abstraction.demo;

public class AbstractionDemoMain {
	public static void main(String args[]) {
		Rectangle r = new Rectangle(10, 20);
		System.out.println("Area :" + r.area());
		System.out.println("Perimeter :" + r.perimeter());
		Rectangle sq = new Rectangle();
		System.out.println("Area :" + sq.area());
		System.out.println("Perimeter :" + sq.perimeter());
		
		Circle c = new Circle(10);
		System.out.print("Area: ");
		System.out.format("%.3f%n", c.area());
		System.out.println("Perimeter :" + c.perimeter());
		
	}
}