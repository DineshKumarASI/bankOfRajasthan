package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.daoImpl.*;
import com.daoImpl.BankDaoImpl;
import com.jdbc.ConnectionJDBC;

public class MainClass {
	public static void main(String[] args)  {		
		BankDaoImpl bank = new BankDaoImpl();
		Scanner scan = new Scanner(System.in);
		int i;
		first:
			do {			
			System.out.println("\nEnter valid option");
			System.out.println("Enter\nInsertion for 1\nUpdate datails for 2\n"
					+ "Remove the account for 3\nShow table for 4\nExit for 0");
			i= scan.nextInt();
			switch(i) {
			case 0: break first;
			case 1: i=bank.addNewUser();
					System.out.println("Insertion successfully "+i+" time");
					break;
			case 2: i = bank.updateUserDetails();
						System.out.println("update successfully "+i+" time");
						break;
						
			case 3: i = bank.removeUser();
						break;
			case 4: bank.showAllAccounts();
			        break;
					
			default: System.out.println("plz enter valid option");
		
					
			}
			
		}while(true);
	}
}


