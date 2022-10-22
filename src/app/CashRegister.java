package app;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		boolean anotherPurchase = true;
		Scanner scanner = new Scanner(System.in);

		while (anotherPurchase) {
			System.out.println("Enter purchase price: ");
			double purchasePrice = scanner.nextDouble();

			System.out.println("Enter amount tendered: ");
			double amountTendered = scanner.nextDouble();

			makinTheChange(purchasePrice, amountTendered);

			System.out.println("Would you like to make another purchase? (Y/N) ");
			String responseString = scanner.next();

			if (!responseString.equalsIgnoreCase("y")) {
				anotherPurchase = false;
				System.out.println("Thanks for shopping!");
			}
		}
		scanner.close();
	}

	public static void makinTheChange(double purchasePrice, double amountTendered) {
		purchasePrice *= 100;
		amountTendered *= 100;
		int changeRemaining = (int) (amountTendered - purchasePrice);
		String changeString = "";

		if (purchasePrice > amountTendered) {
			System.out.println("You are short:");
			makinTheChange(amountTendered / 100, purchasePrice / 100);
		} else if (purchasePrice == amountTendered) {
			System.out.println("Spot on");
		} else {
			while (changeRemaining > 0) {
				if (changeRemaining >= 2000) {
					int numReturn = changeRemaining / 2000;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 2000) + " twenty dollar bill";
					} else {
						changeString += (int) (changeRemaining / 2000) + " twenty dollar bills";
					}
					changeRemaining = changeRemaining % 2000;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 1000) {
					int numReturn = changeRemaining / 1000;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 1000) + " ten dollar bill";
					} else {
						changeString += (int) (changeRemaining / 1000) + " ten dollar bills";
					}
					changeRemaining = changeRemaining % 1000;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 500) {
					int numReturn = changeRemaining / 500;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 500) + " five dollar bill";
					} else {
						changeString += (int) (changeRemaining / 500) + " five dollar bills";
					}
					changeRemaining = changeRemaining % 500;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 100) {

					int numReturn = changeRemaining / 100;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 100) + " one dollar bill";
					} else {
						changeString += (int) (changeRemaining / 100) + " one dollar bills";
					}
					changeRemaining = changeRemaining % 100;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 25) {
					int numReturn = changeRemaining / 25;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 25) + " quarter";
					} else {
						changeString += (int) (changeRemaining / 25) + " quarters";
					}
					changeRemaining = changeRemaining % 25;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 10) {
					int numReturn = changeRemaining / 10;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 10) + " dime";
					} else {
						changeString += (int) (changeRemaining / 10) + " dimes";
					}
					changeRemaining = changeRemaining % 10;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 5) {
					int numReturn = changeRemaining / 5;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 5) + " nickel";
					} else {
						changeString += (int) (changeRemaining / 5) + " nickels";
					}
					changeRemaining = changeRemaining % 5;
					if (changeRemaining >= 1) {
						changeString += ", ";
					} else {
						changeString += ".";
					}
				} else if (changeRemaining >= 1) {
					int numReturn = changeRemaining / 1;
					if (numReturn == 1) {
						changeString += (int) (changeRemaining / 1) + " penny";
					} else {
						changeString += (int) (changeRemaining / 1) + " pennies";
					}
					changeRemaining = changeRemaining % 1;
					changeString += ".";
				}
			}

		}
		System.out.println(changeString);
	}
}
