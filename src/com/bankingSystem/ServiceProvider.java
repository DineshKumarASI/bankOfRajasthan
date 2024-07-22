package com.bankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ServiceProvider {
	private Connection connection;
	private Scanner scanner;

	public ServiceProvider(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}

	public ServiceProvider() {

	}

	public void credit_money(long account_number) {
		scanner.nextLine();
		System.out.println("Enter amount");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Security Pin");
		String security_pin = scanner.nextLine();
		PreparedStatement pst = null;

		try {
			if (account_number != 0) {
				String query = "SELECT*FROM accounts WHERE account_number = ? and security_pin = ?";
				pst = connection.prepareStatement(query);
				pst.setLong(1, account_number);
				pst.setString(2, security_pin);
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					String credit_query = "UPDATE accounts SET balance = balance +? WHERE account_number =? ";

					PreparedStatement prestate1 = connection.prepareStatement(credit_query);

					prestate1.setDouble(1, amount);
					prestate1.setLong(2, account_number);
					int effectedRows = prestate1.executeUpdate();
					if (effectedRows > 0) {
						System.out.println("Rs " + amount + " Credited Successfully");
						return;
					} else {
						System.out.println("Transaction fail");
						
					}

				} else {
					System.out.println("Insufficiant balance");
				}
			} else {
				System.out.println("Invalid Security Pin");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void debit_money(long account_number) {
		scanner.nextLine();
		System.out.println("Enter amount");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Security Pin");
		String security_pin = scanner.nextLine();

		try {
			String query = "SELECT * FROM accounts WHERE account_number = ? and security_pin = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setLong(1, account_number);
			pst.setString(2, security_pin);
			ResultSet rs = pst.executeQuery();
			if (account_number !=0 ) {
				if (rs.next()) {
					double current_balance = rs.getDouble("balance");
					if (amount <= current_balance) {
						String debit_query = "UPDATE accounts SET balance =balance-? WHERE account_number =?";
						PreparedStatement prst = connection.prepareStatement(debit_query);
						prst.setDouble(1, amount);
						prst.setLong(2, account_number);
						int effectedRows = prst.executeUpdate();

						if (effectedRows > 0) {
							System.out.println("Rs " + amount + " \\- debited Successfully");
							System.out.println("Your balance now RS = ");
							System.out.println((current_balance) - (amount));
							
							return;
						} else {
							System.out.println("Transaction fail");
							
						}
					} else {
						System.out.println("Invalid Security Pin");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getBalance() {
		scanner.nextLine();
		System.out.println("Enter account number");
		long account_number = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter Security Pin");
		String security_pin = scanner.nextLine();
		try {
			String query = "SELECT* FROM  accounts WHERE account_number =? and security_pin = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setLong(1, account_number);
			pst.setString(2, security_pin);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
}
