package com.tca;
class ThreadIndia implements Runnable
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println("India:"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class ThreadAus implements Runnable
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println("Aus:"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}



public class RunnableInterfaceThread 
{

	public static void main(String[] args)
	{
	     Thread t1= new Thread (new ThreadIndia ());
	     t1.start();
	     Thread t2= new Thread (new ThreadAus ());
	     t2.start();
	     
	     
	     for(int i=0;i<=2;i++)
	     {
	    	 System.out.println("MAIN :"+i);
	    	 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 t1.interrupt();
	     }
	     
	}

}
