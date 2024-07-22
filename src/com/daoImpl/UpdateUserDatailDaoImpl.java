package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.dao.UpdateUserDatailDao;
import com.entities.BeanClass;
import com.jdbc.ConnectionJDBC;

public class UpdateUserDatailDaoImpl implements UpdateUserDatailDao {
	Connection conn = ConnectionJDBC.createConnection();
	Scanner scanner = new Scanner(System.in);

	@Override
	public int allDetail() {
		try {
			String nam = "UPDATE account_details SET ac_no=?,name=?,pan=?,adhar=?,mobile=?,ac_type=?,e_mail = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(nam);
			System.out.println("Enter account Number ");
			int sNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new account no.");
			String ac_no = scanner.nextLine();
			System.out.println("Enter new name");
			String name = scanner.nextLine();
			System.out.println("Enter new PAN no.");
			String pan = scanner.nextLine();
			System.out.println("Enter new adhar no.");
			String adhar = scanner.nextLine();
			System.out.println("Enter new mobile no.");
			String mobile = scanner.nextLine();
			System.out.println("Enter new account type");
			String ac_type = scanner.nextLine();
			System.out.println("Enter new Email");
			String e_mail = scanner.nextLine();	
			BeanClass entity = new BeanClass(ac_no,name,pan,adhar,mobile,ac_type,e_mail);
			pst.setString(1, entity.getAc_no());
			pst.setString(2, entity.getName());
			pst.setString(3, entity.getPan());
			pst.setString(4, entity.getAdhar());
			pst.setString(5, entity.getMobile());
			pst.setString(6, entity.getAc_type());
			pst.setString(7, entity.getE_mail());
			pst.setInt(8, sNo);		
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int accountNo() {
		try {
			System.out.println("Enter Id(sNo)");
			int sNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new account no.");
			String ac_no = scanner.nextLine();
			String query = "UPDATE account_details SET ac_no = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(query);		
			pst.setInt(2, sNo);
			pst.setString(1, ac_no);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int name() {
		try {
			String nam = "UPDATE account_details SET name = ? WHERE ac_no =? ";
			PreparedStatement pst = conn.prepareStatement(nam);
			System.out.println("Enter account Number ");
			String accountNo = scanner.nextLine();
			System.out.println("Enter new Name");
			String name = scanner.nextLine();			
			pst.setString(2, accountNo);
			pst.setString(1,name);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int pan() {
		try {
			String panNo = "UPDATE account_details SET pan = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(panNo);
			System.out.println("user id");
			int sNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new PAN number");
			String pan = scanner.nextLine();			
			pst.setString(1, pan);
			pst.setInt(2, sNo);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int adhar() {
		try {
			String adharNo = "UPDATE account_details SET adhar = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(adharNo);
			System.out.println("Enter account Number ");
			String accountNo = scanner.nextLine();
			scanner.nextLine();
			System.out.println("Enter adhar Number");
			String adhar = scanner.nextLine();		
			pst.setString(2, accountNo);
			pst.setString(1, adhar);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} return 0;
	}

	@Override
	public int mobile() {
		try {
			String mobileNo = "UPDATE account_details SET mobile = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(mobileNo);
			System.out.println("Enter user id ");
			int sNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter mobile number");
			String mobile = scanner.nextLine();
			BeanClass entity = new BeanClass();
			entity.setMobile(mobile);			
			pst.setInt(2, sNo);
			pst.setString(1, entity.getMobile());
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int acType() {
		try {
			String acctType = "UPDATE account_details SET ac_type = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(acctType);
			System.out.println("Enter user id (sNo)");
			int sNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Account type saving or current");
			String ac_type = scanner.nextLine();
			BeanClass entity = new BeanClass();
			entity.setAc_type(ac_type);			
			pst.setString(1, entity.getAc_type());
			pst.setInt(2, sNo);	
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int email() {
		try {
			String emailId = "UPDATE account_details SET e_mail = ? WHERE sNo = ? ";
			PreparedStatement pst = conn.prepareStatement(emailId);
			System.out.println("Enter user id(sNo)");
			int sNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Account type saving or current");
			String e_mail = scanner.nextLine();
			BeanClass entity = new BeanClass();
			entity.setE_mail(e_mail);
			pst.setString(1, entity.getE_mail());
			pst.setInt(2,sNo);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
				return i;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

}
