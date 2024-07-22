package com.bankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class Client {
	private Connection connection;
	private Scanner scanner;

	public Client(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}

	public Client() {

	}

	public void register() {
		scanner.nextLine();
		System.out.println("Full Name:* ");
		String full_name = scanner.nextLine();
		System.out.println("Email:* ");
		String email = scanner.nextLine();
		System.out.println("Password:* ");
		String password = scanner.nextLine();
		if (user_exist(email)) {
			System.out.println("User allready exists for this email id ");
			return;
		}
		String register_query = "INSERT INTO user(full_name ,email,password) VALUES(?,?,?)";
		try {
			PreparedStatement pst = connection.prepareStatement(register_query);
			pst.setString(1, full_name);
			pst.setString(2, email);
			pst.setString(3, password);
			int effectedRows = pst.executeUpdate();
			if (effectedRows > 0) {
				System.out.println("Registration Successfully ");
			} else {
				System.out.println("Registration Failed ! ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String login() {
		scanner.nextLine();
		System.out.println("Enter user id Email:");
		String email = scanner.nextLine();
		System.out.println("Password");
		String password = scanner.nextLine();
		String login_query = " SELECT *FROM user WHERE email = ? AND password = ?";
		
		try {
			PreparedStatement pst = connection.prepareStatement(login_query);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return email;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
	}

	public boolean user_exist(String email) {
		String query = "SELECT* FROM user WHERE email = ?";

		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} 
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
