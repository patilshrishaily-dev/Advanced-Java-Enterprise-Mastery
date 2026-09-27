package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessingUserInput 

{
   public static void main(String[] args) 
   
   {
	   Connection con=null;
	   PreparedStatement ps=null;
	   Scanner sc=new Scanner(System.in);
	   try
	   {
		   Class.forName("org.postgresql.Driver");
		   con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ajdb21","root","root@123");
		   con.setAutoCommit(false);
		   ps=con.prepareStatement("insert into account values(?,?,?)");
		   while(true)
		   {
			   System.out.println("Enter the Account number:");
			   int n=sc.nextInt();
			   sc.nextLine();
			   System.out.println("Enter the Account name  :");
			   String name=sc.nextLine();
			   System.out.println("Enter the Account balance:");
			   double balance=sc.nextDouble();		  
			   ps.setInt(1, n);
			   ps.setString(2, name);
			   ps.setDouble(3, balance);
			   ps.addBatch();
			   sc.nextLine();
			   
			   System.out.println("DO YOU WANT CONTINUE(YES/NO) :");
			   String option=sc.nextLine();
			   if(option.equalsIgnoreCase("yes"))
			   {
				   continue;
			   }
			   else
			   {
				   break;
			   }
			  
			    
		   }	  
		   ps.executeBatch();
		   con.commit();
		   System.out.println("Record is inserted Successfulyy");
	   }
	   catch(Exception e)
	   {
		   System.out.println("proble..while reflicting changes..!!");
		   e.printStackTrace();
	   }
	   finally
	   {
		   try {
			 sc.close();
			con.close();
			ps.close();

		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   	  
	   }
   }
}
