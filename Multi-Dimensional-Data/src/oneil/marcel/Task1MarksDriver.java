package oneil.marcel;

import java.util.Random;
import java.util.Scanner;

public class Task1MarksDriver {

	public static void main(String[] args) {

		// each column represents a student, each row represents a course
		int[][] marks;

		Scanner in = new Scanner(System.in);

		// Ask the user how many students and how many courses
		// Assume data is correct (positive integers)

		System.out.print("Number of courses : ");
		int numCourses = in.nextInt();

		System.out.print("Number of students: ");
		int numStudents = in.nextInt();

		in.close();

		// Allocate storage for the full 2D array
		marks = new int[numCourses][numStudents];

		System.out.println("Number of Courses :" + marks.length);
		System.out.println("Number of Students:" + marks[0].length);

		// Populate with random marks from 40-100 (inclusive)
		setRandomMarks(marks);

		// Display the marks in a grid
		displayArray(marks);

		// Calculate and Display the student averages (column averages)
		displayStudentAverages(marks);

		// Calculate and Display the course averages (row averages)
		displayCourseAverages(marks);
	}

	private static void setRandomMarks(int[][] arr) {

		Random rand = new Random(1234); // seed

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = rand.nextInt(101);
			}
		}
	}

	private static void displayArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// row Average
	private static void displayCourseAverages(int[][] arr) {
		System.out.println("Course Averages");
		for (int i = 0; i < arr.length; i++) {
			double average = 0;
			for (int j = 0; j < arr[0].length; j++) {
				average += arr[i][j];
			}
			average /= arr[0].length;
			System.out.println("Course " + (i+1) + " average is " + average);
		}
	}

	// column averages
	private static void displayStudentAverages(int[][] arr) {
		System.out.println("Student Averages");
		for (int i = 0; i < arr[0].length; i++) {
			double average = 0;
			for (int j = 0; j < arr.length; j++) {
				average += arr[j][i];
			}
			average /= arr.length;
			System.out.println("Student " + (i+1) + " average is " + average);
		}
	}
}
