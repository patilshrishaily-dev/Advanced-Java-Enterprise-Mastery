package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*

 */
public class Scroll_Insensitive

{
	public static final String DB_DRIVER = ("org.postgresql.Driver");
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root@123";

	public static void main(String[] args) {

		Statement stmt = null;
		Connection con = null;
		// PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			// ps=con.prepareStatement("select * from student order by
			// (rno)",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			// rs=ps.executeQuery();using preparedStatement
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select * from student");// using statement
			while (rs.next()) {
				System.out.println("Roll Number:" + rs.getInt(1));
				System.out.println("Name       :" + rs.getString(2));
				System.out.println("Percentage :" + rs.getDouble(1));
				System.out.println("---------------------------------");
			}
			System.out.println("RECORD ARE DISPLAYE IN FORWARD WAY..!!");

			while (rs.previous()) {
				System.out.println("Roll Number:" + rs.getInt(1));
				System.out.println("Name       :" + rs.getString(2));
				System.out.println("Percentage :" + rs.getDouble(1));
				System.out.println("---------------------------------");
			}
			System.out.println("RECORD ARE DISPLAYE IN BACKWORD WAY..!!");
			System.out.println("===========================================================");

			System.out.println("*********RECORD ARE DISPLAY RANDOM POSITION******************");
			rs.absolute(2);
			System.out.println(
					"Second Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");
			rs.absolute(3);
			System.out.println(
					"Third Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");
			rs.first();
			System.out.println(
					"First Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");
			rs.last();
			System.out.println(
					"Last Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");

		} catch (Exception e) {
			System.out.println("problem while closing resources..!!");
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
				// ps.close();
				stmt.close();

			} catch (Exception e) {
				System.out.println("Problem..!!");
				e.printStackTrace();
			}

		}
	}

}
