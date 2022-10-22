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
			System.out.println("Spot on!!!");
		} else {
			while (changeRemaining > 0) {
				if (changeRemaining >= 2000) {
					int numReturn = changeRemaining / 2000;
					changeRemaining = changeRemaining % 2000;
					changeString += singleOrPlural(numReturn, changeRemaining, " twenty dollar bill");
				} else if (changeRemaining >= 1000) {
					int numReturn = changeRemaining / 1000;
					changeRemaining = changeRemaining % 1000;
					changeString += singleOrPlural(numReturn, changeRemaining, " ten dollar bill");
				} else if (changeRemaining >= 500) {
					int numReturn = changeRemaining / 500;
					changeRemaining = changeRemaining % 500;
					changeString += singleOrPlural(numReturn, changeRemaining, " five dollar bill");
				} else if (changeRemaining >= 100) {
					int numReturn = changeRemaining / 100;
					changeRemaining = changeRemaining % 100;
					changeString += singleOrPlural(numReturn, changeRemaining, " one dollar bill");
				} else if (changeRemaining >= 25) {
					int numReturn = changeRemaining / 25;
					changeRemaining = changeRemaining % 25;
					changeString += singleOrPlural(numReturn, changeRemaining, " quarter");
				} else if (changeRemaining >= 10) {
					int numReturn = changeRemaining / 10;
					changeRemaining = changeRemaining % 10;
					changeString += singleOrPlural(numReturn, changeRemaining, " dime");
				} else if (changeRemaining >= 5) {
					int numReturn = changeRemaining / 5;
					changeRemaining = changeRemaining % 5;
					changeString += singleOrPlural(numReturn, changeRemaining, " nickel");
				} else if (changeRemaining >= 1) {
					int numReturn = changeRemaining / 1;
					changeRemaining = changeRemaining % 1;
					changeString += singleOrPlural(numReturn, " penny", " pennies");
				}
			}

		}
		System.out.println(changeString);
	}

	public static String singleOrPlural(int numReturn, int changeRemaining, String moneyType) {
		String commaOrPeriod = "";
		String addS = "";
		if (changeRemaining >= 1) {
			commaOrPeriod = ", ";
		} else {
			commaOrPeriod = ".";
		}
		if (numReturn > 1) {
			addS = "s";
		}
		return numReturn + moneyType + addS + commaOrPeriod;
	}

	public static String singleOrPlural(int numReturn, String moneyType, String pluralString) {
		if (numReturn > 1) {
			return numReturn + pluralString + ".";
		}
		return numReturn + moneyType + ".";
	}

}
