package oneil.marcel;

/**
 * Circle on a cartesian grid.
 * 
 * @author Marcel O'Neil
 * @version 1.0
 */
public class Circle {
	private Point location;
	private double radius;

	/**
	 * Circle constructor. Default location is the origin.
	 * 
	 * @param radius
	 *            circle's radius
	 */
	public Circle(double radius) {
		this.location = new Point();
		this.radius = radius;
	}

	/**
	 * Circle constructor.
	 * 
	 * @param radius
	 *            circle's radius
	 * @param location
	 *            circle's center location
	 */
	public Circle(double radius, Point location) {
		this.location = location;
		this.radius = radius;
	}

	/**
	 * Update the location of the center of the circle
	 * 
	 * @param location
	 *            new location of the circle
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * Update the radius of the circle.
	 * 
	 * @param radius
	 *            circle's radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Obtain the location of the circle.
	 * 
	 * @return location
	 */
	public Point getLocation() {
		return this.location;
	}

	/**
	 * Obtain the radius of the circle.
	 * 
	 * @return radius
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * Obtain the area of the circle.
	 * 
	 * @return area
	 */
	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	/**
	 * Obtain the circumference of the circle.
	 * 
	 * @return circumference
	 */
	public double circumference() {
		return 2 * Math.PI * this.radius;
	}

	/**
	 * Determine if a Point is located inside of the circle
	 * 
	 * @param point
	 *            Point to check
	 * @return true if the Point is inside the circle otherwise false
	 */
	public boolean isPointInside(Point point) {
		if (point.distanceFrom(this.location) > radius)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Location: %s\nRadius: %.2f", this.location.toString(), this.radius);
	}
}
