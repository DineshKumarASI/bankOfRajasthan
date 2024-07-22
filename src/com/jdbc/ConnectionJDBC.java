package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC
{
	public static Connection createConnection() {
		Connection connection = null;
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bank_of_rajasthan";
			String userName ="root";
			String password = "MySQL@1985";
			connection = DriverManager.getConnection(url,userName,password);
			//System.out.println("dgf");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return connection;
		
	}
	
	
}

//	public static Connection connectionJDBC(){
//		
//		Connection connection= null;
//		try {
//			//load and registration driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//create connection
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaclass","root","MySQL@1985");
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return connection;
//	}
//}