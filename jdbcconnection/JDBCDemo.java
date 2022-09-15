	package com.assignment4.jdbcconnection;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class JDBCDemo {

		public static void main(String[] args) {
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "SRojesh091692");

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM ebookshop.books");

				while (rs.next()) {
					// Display values
					System.out.println("Id:"+rs.getString(1) + "   Tittle :" + rs.getString(2) + "   Author: " + rs.getString(3) + "   Price: "
							+ rs.getString(4) + " Qty: " + rs.getString(5));
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error Coonecting database");
			} finally {
				if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

