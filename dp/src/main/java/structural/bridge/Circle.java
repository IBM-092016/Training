package structural.bridge;

public class Circle extends Shape {
	private int mX, mY, mRadius;

	public Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.mX = x;
		this.mY = y;
		this.mRadius = radius;
	}

	public void draw() {
		mDrawAPI.drawCircle(mRadius, mX, mY);
	}
}
