package com.bankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Service {
	private Connection connection;
	private Scanner scanner;

	public Service(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}

	//public long open_account(String emails) {
		
	

	private long generateAccountNumber() {
		String query = "SELECT account_number from Accounts ORDER BY account_number DESC LiMIT 1";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				long last_account_number = rs.getLong("account_number");
				return ++last_account_number;
			} else {
				return 1001;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 1001;

	}

	public long getAccount_number(String email) {
		String query = "SELECT account_number from accounts WHERE email =?";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getLong("account_number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Account Number does't exist");
	}
	public boolean account_exist(String email1) {
		System.out.println(" =>> You want to banking service... ");
		String query = "SELECT * FROM accounts WHERE full_name = ? AND email = ? ";
		System.out.println(" =>>pse Enter your name same as account");
		String full_name = scanner.nextLine();	
		System.out.println("pse Enter your login email");
		String email = scanner.nextLine();		
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, full_name);
			pst.setString(2, email);			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		return false;
		
	}

	public long open_account(String emails) {
		String query = "INSERT INTO accounts(account_number,full_name,email,balance,security_pin) VALUES(?,?,?,?,?)";
		scanner.nextLine();
		System.out.println("Enter Full Name");
		String full_name = scanner.nextLine();
		System.out.println("Enter Email");
		String email = scanner.nextLine();
		System.out.println("deposit initial amount ");
		double balance = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Security Pin");
		String security_pin = scanner.nextLine();
		long account_number = generateAccountNumber();

		try {
			
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setLong(1, account_number);
			pst.setString(2, full_name);
			pst.setString(3, email);
			pst.setDouble(4, balance);
			pst.setString(5, security_pin);
			int effectedRows = pst.executeUpdate();
			if (effectedRows > 0) {
				return account_number;
			} else {
				throw new RuntimeException("Account Creation Failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Account already exist");
		
	}

}
