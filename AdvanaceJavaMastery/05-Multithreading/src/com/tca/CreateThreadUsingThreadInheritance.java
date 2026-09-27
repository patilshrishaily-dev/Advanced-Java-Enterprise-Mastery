package com.tca;
/*


 */  

class IndiaThread extends Thread
{
	public void run()//Thread action method
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("INDIA::"+i);
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				
				e.printStackTrace();
			}
		}
	}
}
class AusThread extends Thread
{
	public void run()//Thread action method
	{
		
		try
		{
			//Thread t=Thread.currentThread();
	
		for(int i=1;i<=5;i++)
		{
			System.out.println("Aus::"+i);
			Thread.sleep(1000);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

public class CreateThreadUsingThreadInheritance 
{

	public static void main(String[] args)
	{
	   IndiaThread t1=new IndiaThread();
	   t1.start();//allocating required resources -Stack/cpu Registers/Ip(Instruction Pointer)
	   t1.setName("INDIA-thread");
	   AusThread t2=new AusThread();
	   t2.start();//allocating required resources -Stack/cpu Registers/Ip(Instruction Pointer)
	   t2.setName("AUS_thread");
	   System.out.println("Thread t1:"+t1);
	   System.out.println("Thread t2:"+t2);
	   for(int i=0;i<=5;i++)
	   {
		   System.out.println("Main"+i);
		   try {
			Thread.sleep(1000);
		} 
		   catch (InterruptedException e)
		   {
			
			e.printStackTrace();
		}
	   }
	}

}
