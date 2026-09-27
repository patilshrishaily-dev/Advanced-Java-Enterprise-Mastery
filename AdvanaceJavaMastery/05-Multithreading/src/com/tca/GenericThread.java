package com.tca;
/*
 * 
 */
class PrintTextThread extends Thread
{
	String msg;int n;
	public PrintTextThread(String msg,int n)
	{
		this.msg=msg;
		this.n=n;
	}
	public void run()
	{
		
		//System.out.println("Messeage  :"+msg);
		//System.out.println("N          :"+n);
		try
		{
			for(int i=0;i<n;i++)
			{
				System.out.println("Messegae  :"+msg);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}

public class GenericThread 
{
	public static void main(String[] args)
	{
		PrintTextThread t1=new PrintTextThread("India",5);
		t1.start();
		PrintTextThread t2=new PrintTextThread("Aus",3);
		t2.start();
	}

}
