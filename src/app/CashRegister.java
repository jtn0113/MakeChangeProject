package app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
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

		HashMap<String, Integer> currency = new LinkedHashMap<String, Integer>();
		currency.put("twenty dollar bill", 2000);
		currency.put("ten dollar bill", 1000);
		currency.put("five dollar bill", 500);
		currency.put("one dollar bill", 100);
		currency.put("quarter", 25);
		currency.put("dime", 10);
		currency.put("nickel", 5);
		currency.put("penny", 1);

		if (purchasePrice > amountTendered) {
			System.out.println("You are short:");
			makinTheChange(amountTendered / 100, purchasePrice / 100);
		} else if (purchasePrice == amountTendered) {
			System.out.println("Spot on!!!");
		} else {
			for (Entry<String, Integer> entry : currency.entrySet()) {
				if (changeRemaining >= entry.getValue()) {
					int numReturn = changeRemaining / entry.getValue();
					changeRemaining = changeRemaining % entry.getValue();
					if (entry.getValue() == 1) {
						changeString += singleOrPlural(numReturn, entry.getKey(), "pennies");
					} else {
						changeString += singleOrPlural(numReturn, changeRemaining, entry.getKey());
					}
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
		return numReturn + " " + moneyType + addS + commaOrPeriod;
	}

	public static String singleOrPlural(int numReturn, String moneyType, String pluralString) {
		if (numReturn > 1) {
			return numReturn + " " + pluralString + ".";
		}
		return numReturn + " " + moneyType + ".";
	}
}
