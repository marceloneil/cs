package oneil.marcel;

/**
 * Point on a cartesian coordinate system.
 * 
 * @author Marcel O'Neil
 * @version 1.0
 */
public class Point {
	private double x;
	private double y;

	/**
	 * Point constructor.
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Point constructor.
	 * 
	 * @param x
	 *            the point's x coordinate
	 * @param y
	 *            the point's y coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Update the position of a point.
	 * 
	 * @param x
	 *            the point's new x coordinate
	 * @param y
	 *            the point's new y coordinate
	 */
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Obtain the x coordinate.
	 * 
	 * @return x coordinate
	 */
	public double getXvalue() {
		return this.x;
	}

	/**
	 * Obtain the y coordinate.
	 * 
	 * @return y coordinate
	 */
	public double getYvalue() {
		return this.y;
	}

	/**
	 * Calculate the distance the point is from the origin (0,0)
	 * 
	 * @return distance from the origin
	 */
	public double distanceFromOrigin() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/**
	 * Calculate the distance the point is from another point
	 * 
	 * @param point
	 *            location of the other point
	 * @return distance between the points
	 */
	public double distanceFrom(Point point) {
		return Math.sqrt(Math.pow(this.x - point.getXvalue(), 2) + Math.pow(this.y - point.getYvalue(), 2));
	}

	@Override
	public String toString() {
		return String.format("(%.2f, %.2f)", this.x, this.y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point point = (Point) obj;
			if (this.x == point.getXvalue() && this.y == point.getYvalue())
				return true;
		}
		return false;
	}
}
