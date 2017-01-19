package oneil.marcel;

public class Account extends Investment {
	private int id;
	private double balance;
	private static int nextID = 0;

	private static int getID() {
		nextID++;
		return nextID;
	}

	public Account() {
		this.id = getID();
		this.balance = 0;
	}

	public double getBalance() {
		return this.balance;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdrawal(double amount) {
		if (amount > this.balance) {
			throw new IllegalArgumentException("You don't have enough money");
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return String.format("Account ID: #%d\nBalance: $%.2f", this.id, this.balance);
	}
}
