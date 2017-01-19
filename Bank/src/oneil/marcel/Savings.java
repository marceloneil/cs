package oneil.marcel;

public class Savings extends Account {
	private double rate;

	public Savings(double rate) {
		super();
		this.rate = rate;
	}

	public void applyInterest() {
		super.deposit(super.getBalance() * (rate / 100));
	}

	@Override
	public String toString() {
		return String.format(super.toString() + "\nRate: %.2f%%", rate);
	}
}
