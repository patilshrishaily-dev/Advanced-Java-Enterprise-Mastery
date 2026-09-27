package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudent
{
	public static final String DB_DRIVER=("org.postgresql.Driver");
	public static final String DB_URL="jdbc:postgresql://localhost:5432/ajdb21";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="root@123";
   public static void main(String[] args) 
   {
	   
       
	   Connection con=null;
	   Statement   stmt=null;
	   ResultSet rs=null;
	   try
	   {
		   Class.forName(DB_DRIVER);
		   con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		   stmt=con.createStatement();
		   rs=stmt.executeQuery("select * from student order by (rno)");
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		   }
		   System.out.println("Records are displayed successsfully..!!");
		   
		   
	   }
	   catch(Exception e)
	   {
		   System.out.println("problem while closing resources..!!");
		   e.printStackTrace();
	   }
	   finally
	   {
		   try {
		   con.close();
		   rs.close();
		   stmt.close();
		   
	   }catch(Exception e)
		   {
		       System.out.println("Problem..!!");
		       e.printStackTrace();
		   }
	   
	   }	}
}
