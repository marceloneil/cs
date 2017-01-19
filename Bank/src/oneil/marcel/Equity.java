package oneil.marcel;

public class Equity extends Investment {
	private String name;
	private int quantity;
	private double price;
	private double value;

	public Equity(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.value = this.price * this.quantity;
	}

	@Override
	public String toString() {
		return String.format("Stock Name %s\nValue: $%.2f", this.name, this.value);
	}

	@Override
	public double getBalance() {
		return this.value;
	}
}
