package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * 
                
 */

public class BalanceTransferApp 
{
	public static final String DB_DRIVER = ("org.postgresql.Driver");
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root@123";
	public static void main(String[] args)
	{
	   Connection con=null;
	   PreparedStatement ps1=null;
	   PreparedStatement ps2=null;
	   try
	   {
		   Class.forName(DB_DRIVER);
		   con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		   con.setAutoCommit(false); //Don't perform Auto Commit..!!
		   ps1=con.prepareStatement("update account set balance=balance-500 where ano=101");
		   ps1.executeUpdate();
		   Integer.parseInt("shree");//Exception or error occured but app is securly run
		   ps2=con.prepareStatement("update account set balance=balance+500 where ano=102");
		   ps2.executeUpdate();
		   con.commit();//plz reflect my changes in database..!!
		   System.out.println("Amount is transferred successsfully..!!");
	   }
	   catch(Exception e)
	   {
		   System.out.println("transacation failed..!!");
			try {
				con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}

	   }
	   finally
	   {
		   try {
			con.close();
			ps1.close();
			ps2.close();
		   } 
		   catch (SQLException e) 
		   {
			
			e.printStackTrace();
		   }
		  
	   }
	   
	}

}
