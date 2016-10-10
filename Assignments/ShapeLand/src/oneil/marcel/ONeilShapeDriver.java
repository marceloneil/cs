package oneil.marcel;

import java.util.Scanner;

public class ONeilShapeDriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// Point 1
		double x1 = readDouble(s, "Enter the x-coordinate of Point 1: ");
		double y1 = readDouble(s, "Enter the y-coordinate of Point 1: ");
		Point point1 = new Point(x1, y1);
		System.out.println("Point 1 is: " + point1.toString() + "\n");

		// Point 2
		double x2 = readDouble(s, "Enter the x-coordinate of Point 2: ");
		double y2 = readDouble(s, "Enter the y-coordinate of Point 2: ");
		Point point2 = new Point(x2, y2);
		System.out.println("Point 2 is: " + point2.toString() + "\n");

		// Info about Point 1 and 2
		if (point1.distanceFrom(point2) == 0)
			System.out.println("Point 1 and Point 2 are the same");
		else
			System.out.println("Point 1 and Point 2 are different");

		System.out.printf("Distance of Point 1 from origin is: %.2f\n", point1.distanceFromOrigin());
		System.out.printf("Distance of Point 2 from origin is: %.2f\n", point2.distanceFromOrigin());

		Line line = new Line(point1, point2);
		System.out.printf("Distance of line segment joining Point 1 and 2 is: %.2f\n\n", line.length());

		// Circle
		double x = readDouble(s, "Enter the x-coordinate of the circle: ");
		double y = readDouble(s, "Enter the y-coordinate of the circle: ");
		double radius = readDouble(s, "Enter the radius of the circle: ");
		Circle circle = new Circle(radius, new Point(x, y));
		System.out.println(circle.toString() + "\n");

		// Info about Circle
		System.out.printf("Area of the circle is: %.2f\n", circle.area());
		System.out.printf("Circumference of the circle is: %.2f\n", circle.circumference());

		if (circle.isPointInside(point1))
			System.out.println("Point 1 is inside the circle");
		else
			System.out.println("Point 1 is not inside the circle");

		s.close();
	}

	public static double readDouble(Scanner s, String prompt) {
		double input = 0;
		boolean invalid = false;

		do {
			System.out.print(invalid ? "Please input a valid double: " : prompt);
			if (s.hasNextDouble()) {
				input = s.nextDouble();
				invalid = false;
			} else {
				invalid = true;
				s.nextLine();
			}
		} while (invalid);
		return input;
	}
}
