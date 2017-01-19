package oneil.marcel;

public class Task2MatrixMultiplicationDriver {

	public static void main(String[] args)  {
		
		 // each column represents the price of each item 
		 double[][] prices = { 
				 { 12.00 }, 
				 { 23.45 }, 
				 { 15.67 }, 
				 { 4.99  }}; 
		 
		 // each row represents the quantity sold of each item on each day of the week 
		 double[][] daily_sales = { 
				 { 29, 33, 27, 15 }, 
				 { 22, 28, 27, 20 }, 
				 { 40, 38, 22, 16 }, 
				 { 16, 37, 10, 37 }, 
				 { 23, 12, 32, 12 } };
		 
		System.out.println("Prices");
		printArray(prices);
		System.out.println("Daily Quantities");
		printArray(daily_sales);

		try {
			double[][] output = multiply_matrix(daily_sales, prices);

			System.out.println("DAILY SALES");
			printArray(output);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static double[][] multiply_matrix(double[][] arr1, double[][] arr2) {
		// m x n * n x p = m x p ARRAY
		int aRows = arr1.length;
		int aCols = arr1[0].length;
		int bRows = arr2.length;
		int bCols = arr2[0].length;

		if (aCols != bRows) {
			throw new IllegalArgumentException(
					"Array 1 had " + aCols + " columns, and Array 2 had " + bRows + " rows.");
		}

		double[][] result = new double[aRows][bCols];
		
		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bCols; j++) {
				for (int k = 0; k < aCols; k ++){
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		return result;
	}

	private static void printArray(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.printf("%.2f ", arr[i][j]);
			}
			System.out.println();
		}
	}
}
