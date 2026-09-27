package com.tca;
/*

 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scroll_Sensitive 
{
	
	public static final String DB_DRIVER = ("org.postgresql.Driver");
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root@123";
	public static void main(String[] args) 
	{

		Statement stmt = null;
		Connection con = null;
		// PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			// ps=con.prepareStatement("select * from student order by
			// (rno)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			// rs=ps.executeQuery();using preparedStatement
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from student");// using statement
			while (rs.next()) {
				System.out.println("Roll Number:" + rs.getInt(1));
				System.out.println("Name       :" + rs.getString(2));
				System.out.println("Percentage :" + rs.getDouble(3));
				System.out.println("---------------------------------");
			}
			System.out.println("RECORD ARE DISPLAYE IN FORWARD WAY..!!");

			while (rs.previous()) {
				System.out.println("Roll Number:" + rs.getInt(1));
				System.out.println("Name       :" + rs.getString(2));
				System.out.println("Percentage :" + rs.getDouble(3));
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
			rs.absolute(1);
			System.out.println("**********BEFORE DATABASE CHANGE*******************************");
			System.out.println("FIRST Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");
			System.out.println("Press any key to Continue..!!");
			System.in.read();
			rs.refreshRow();
			System.out.println("**********After DATABASE CHANGE*******************************");
			System.out.println("FIRST Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");
			//update 4 th row and changes reflect in database//
			rs.absolute(4);
			rs.updateString(2,"AISHU");
			rs.updateDouble(3,700.00);
			rs.updateRow();
			System.out.println("Record is updated successsfullly"+rs.getInt("rno"));
			System.out.println("=============================================================");
			//delete 3 rd row and changes reflect in database//
			rs.absolute(3);
			System.out.println("**********BEFORE DATABASE DELETE*******************************");
			System.out.println("THIRD  Row-->" + "rno:" + rs.getInt(1) + " Name:" + rs.getString(2) + " Per:" + rs.getDouble(3));
			System.out.println("===========================================================");
			rs.deleteRow();
			System.out.println(".....RECORD IS DELETED SUCCESSFULLY  ....");

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
