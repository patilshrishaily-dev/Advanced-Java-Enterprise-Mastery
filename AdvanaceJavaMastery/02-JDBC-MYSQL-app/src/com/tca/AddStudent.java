package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent 
{
   public static void main(String[] args) 
   {
	   
	   Connection con=null;
	   PreparedStatement ps=null;
	   final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	   final String DB_URL="jdbc:mysql://localhost:3306/ajdb21";
	   final String DB_USERNAME="root";
       final String DB_PASS="";
  try
 {
	   Class.forName(DB_DRIVER);
	   con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASS);
	   ps=con.prepareStatement("insert into student values(25,'shree',60)");
	   ps.executeUpdate();
	   System.out.println("Record is saved successfullY..!!");
	   
}
   catch(Exception e)
   {
	   System.out.println("Problem..!! while  connection performed..!");
	   e.printStackTrace();
   }
  finally
  {
	  try
	  {
		  con.close();
		  ps.close();	  
	  }
	  catch(Exception e)
	  {
		 System.out.println("Problem ..!!while closing connecton..!!");
		 e.printStackTrace();
	  }
	 
  }
} 
}
