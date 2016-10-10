package oneil.marcel;

/**
 * Line segment on a cartesian coordinate system.
 * 
 * @author Marcel O'Neil
 * @version 1.0
 */
public class Line {
	private Point point1;
	private Point point2;

	/**
	 * Line segment constructor.
	 * 
	 * @param point1
	 *            starting point of the line segment
	 * @param point2
	 *            end point of the line segment
	 */
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	/**
	 * Length of the line segment.
	 * 
	 * @return length from start to end of the line segment
	 */
	public double length() {
		return point1.distanceFrom(point2);
	}
}
