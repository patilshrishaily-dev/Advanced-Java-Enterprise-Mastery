package com.tca;
/*
 *
 *  
 */
class Resource
{
	int count=0;
	public   void increament()
	{
		System.out.println("Hello Shree..!!");
		synchronized(this)
		{
		count=count+1;
		}
		System.out.println("Hello Shiv..!!");
		System.out.println("Hello Archana..!!");


}
}
class AddThread extends Thread
{
	Resource r;
	public AddThread(Resource r)
	{
		this.r=r;
	}
	public void run()
	{
		for(int i=1;i<=5000;i++)
		{
			r.increament();
		}
	}	
}

public class Synchronization 
{

	public static void main(String[] args) throws InterruptedException 
	{
	  Resource r=new Resource();
	  AddThread t1=new AddThread(r);
	  AddThread t2=new AddThread(r);
	  t1.start();
	  t2.start();
	  t2.join();
	  t1.join();
	  System.out.println("Count is:"+r.count);
   
	}

}
