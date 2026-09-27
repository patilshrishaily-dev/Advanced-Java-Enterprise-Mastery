package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
/*

 */
public class Batch_Processing_Demo 
{
     public static void main(String[] args) 
    {
		Connection con=null;
		Statement stmt=null;
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ajdb21","root","root@123");
			con.setAutoCommit(false);
			stmt=con.createStatement();
			/*
			stmt.addBatch("insert into account values(55,'aaa',7000)");
			stmt.addBatch("insert into account values(66,'bbb',17000)");
			stmt.addBatch("insert into account values(77,'ccc',27000)");
			stmt.addBatch("insert into account values(88,'ddd',37000)");
			*/
			stmt.addBatch("insert into account values(11,'ppp',8000)");
			stmt.addBatch("update account set balance=400 where balance>=7000");
			stmt.addBatch("delete from account where ano=88");
			int sl[]=stmt.executeBatch();
			System.out.println("no of rows effectes"+Arrays.toString(sl));
			con.commit();
			System.out.println("RECOORD IS INSERTED SUCCSSFULLY..!!");
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			} 
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				stmt.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
}
