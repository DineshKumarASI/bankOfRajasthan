package com.bankingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class BankMain {
	private static final String url = "jdbc:mysql://localhost:3306/bank_of_rajasthan";
	private static final String userName = "root";
	private static final String password = "MySQL@1985";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			Scanner scanner = new Scanner(System.in);
			Client client = new Client(connection, scanner);
			Service service = new Service(connection, scanner);
			ServiceProvider serviceProvider = new ServiceProvider(connection, scanner);

			String email;
			long account_number;

			while (true) {
				System.out.println();
				System.out.println("\n     ** Welecome ** \n*** Bank of Rajasthan *** ");
				System.out.println();
				System.out.println("=> 1. Registration");
				System.out.println("=> 2. login ");
				System.out.println("=> 3. exit");
				System.out.println("=> Enter choice");
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1:
					client.register();

					break;
				case 2:
					email = client.login();
					if (email != null) {
						System.out.println("=>> User logged in!");
						if (!service.account_exist(email)) {
							System.out.println(" => You are not register Here choose option ");
							System.out.println();
							System.out.println(" => 1. Open a new account");
							System.out.println(" => 2. Close page ");
							if (scanner.nextInt() == 1) {
								account_number = service.open_account(email);
								System.out.println("Your Account Number is: " + account_number);
								break;
							    } else {
								  break;
							}
						}
						account_number = service.getAccount_number(email);
						int choice2 = 0;
						//System.out.println("your account no. is " + account_number);
						while (choice2 != 4) {
							System.out.println(" => 1. Debit Money");
							System.out.println(" => 2. Credit Money");
							System.out.println(" => 3. Check Balance");
							System.out.println(" => 4. logOut");
							System.out.println("Enter your choice: ");

							choice2 = scanner.nextInt();
							switch (choice2) {
							case 1:
								serviceProvider.debit_money(account_number);
								break;
							case 2:
								serviceProvider.credit_money(account_number);
								break;

							case 3:
								serviceProvider.getBalance();
								break;
							case 4:
								break;
							default:
								System.out.println("Enter Valid choice");
								break;
							}
						}
					} else {
						System.out.println("incorrect Email or password");
						return;
					}
				case 3:
					System.out.println("Thank you  \n       You are logged out now");
					return;
				default:
					System.out.println("Enter valid choise");
					break;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
