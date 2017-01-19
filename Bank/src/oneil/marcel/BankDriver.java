package oneil.marcel;

import java.util.ArrayList;

public class BankDriver {

	public static void main(String[] args) {
		try {
			Account a = new Account();
			a.deposit(500);
			System.out.println(a);
			a.withdrawal(250);
			System.out.println(a);
			System.out.println();

			Savings s = new Savings(2.5);
			s.deposit(1000);
			s.applyInterest();
			System.out.println(s);
			System.out.println();

			Equity e = new Equity("IBM", 150.78, 100);
			System.out.println(e);
			System.out.println();

			ArrayList<Investment> portfolio = new ArrayList<>();
			portfolio.add(a);
			portfolio.add(s);
			portfolio.add(e);

			double total = 0.0;
			for (Investment investment : portfolio) {
				total += investment.getBalance();
			}
			System.out.printf("Portfolio total is: $%.2f", total);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
