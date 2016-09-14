package oneil.marcel;

public class Item {
	private String name;
	private double price;
	private int quantity;
	private double salesTax = 1.13;

	public Item(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public double getPrice() {
		return (this.price * this.quantity) * this.salesTax;
	}
}
