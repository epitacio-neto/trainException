package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.Exception.DomainException;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimite = sc.nextDouble();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimite);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.printf("New balance: %.2f%n", account.getBalance());
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid answer!");
		}

		sc.close();
	}

}
