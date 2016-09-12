package oneil.marcel;

import java.util.Scanner;
import java.text.NumberFormat;

public class Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		NumberFormat money = NumberFormat.getCurrencyInstance();
		
		System.out.print("Enter name of item: ");
		String name = s.nextLine();
		System.out.print("Enter price of item: ");
		double price = s.nextDouble();
		System.out.print("Enter the quantity desired: ");
		int quantity = s.nextInt();

		Item item = new Item(name, price, quantity);
		
		System.out.print("Total amount is: ");
		System.out.println(money.format(item.getPrice()));
	}

}
