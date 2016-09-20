package structural.bridge;

public abstract class Shape {
	protected DrawAPI mDrawAPI;

	protected Shape(DrawAPI pDrawAPI) {
		this.mDrawAPI = pDrawAPI;
	}

	public abstract void draw();
}
