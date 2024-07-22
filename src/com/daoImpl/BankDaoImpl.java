package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.dao.BankDao;
import com.dao.*;
import com.entities.BeanClass;
import com.jdbc.ConnectionJDBC;

public class BankDaoImpl implements BankDao {
	Scanner scanner = new Scanner(System.in);
	Connection conn = ConnectionJDBC.createConnection();

	@Override
	public int addNewUser() {
		try {
			String insert = "insert into account_details(ac_no,name,pan,adhar,mobile,ac_type,e_mail) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(insert);
			System.out.println("Enter Account number ");
			String ac_no = scanner.nextLine();
			System.out.println("Enter account holder name");
			String name = scanner.nextLine();
			System.out.println("Enter pan number ");
			String pan = scanner.nextLine();
			System.out.println("Enter adhar number");
			String adhar = scanner.nextLine();
			System.out.println("Enter mobile number");
			String mobile = scanner.nextLine();
			System.out.println("Enter account type(saving or current");
			String ac_type = scanner.nextLine();
			System.out.println("Enter your email id");
			String e_mail = scanner.nextLine();
			BeanClass entity = new BeanClass(ac_no, name, pan, adhar, mobile, ac_type, e_mail);
			pst.setString(1, entity.getAc_no());
			pst.setString(2, entity.getName());
			pst.setString(3, entity.getPan());
			pst.setString(4, entity.getAdhar());
			pst.setString(5, entity.getMobile());
			pst.setString(6, entity.getAc_type());
			pst.setString(7, entity.getE_mail());

			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("insertion successfully ");
				return i;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserDetails() {
		int num;
		first: do {
			System.out.println("plz enter update option");
			System.out.println("Enter\n1 = Account No.\n2 = Name\n3 = PAN No.\n4 = Adhar No.\n"
					+ "5 = Mobile No.\n6 = Acct. Type\n7 = Email id \n0 = Exit");
			num = scanner.nextInt();
			UpdateUserDatailDaoImpl update = new UpdateUserDatailDaoImpl();
			switch (num) {
			case 0:
				break first;
			case 1:
				return update.accountNo();
			case 2:
				return update.name();
			case 3:
				return update.pan();
			case 4:
				return update.adhar();
			case 5:
				return update.mobile();
			case 6:
				return update.acType();
			case 7:
				return update.email();
			default:
				System.out.println("plz enter valid number");
			}
		} while (true);
		return 0;
	}

	@Override
	public int removeUser() {
		try {
			String delete = "delete from account_details where sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(delete);
			System.out.println("Enter user Id");
			int sNo = scanner.nextInt();
			pst.setInt(1, sNo);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println(i + " delete successfully");
				return i;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return 0;
	}

	@Override
	public void showAllAccounts() {
		try {
			PreparedStatement pst = conn.prepareStatement("select*from account_details");
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				BeanClass entity = new BeanClass(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
				System.out.print(entity.getsNo() + " ");
				System.out.print(entity.getAc_no() + " ");
				System.out.print(entity.getName() + " ");
				System.out.print(entity.getPan() + " ");
				System.out.print(entity.getAdhar() + " ");
				System.out.print(entity.getMobile() + " ");
				System.out.print(entity.getAc_type() + " ");
				System.out.println(entity.getE_mail());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
