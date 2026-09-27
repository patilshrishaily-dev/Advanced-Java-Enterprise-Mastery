package com.tca;
/*

 */
public class ThreadDemo 

{
  public static void main(String[] args)
  
  {
	System.out.println("Hello users..!!");
	Thread t=Thread.currentThread();
	System.out.println("Thread  :"+t);
	System.out.println("Thread Name:"+t.getName());
	System.out.println("Thread Proiority"+t.getPriority());
	System.out.println("Thread Group :"+t.getThreadGroup());
	System.out.println("Thread is Running"+t.isAlive());
	System.out.println(Thread.MAX_PRIORITY);
	System.out.println(Thread.MIN_PRIORITY);
	System.out.println(Thread.NORM_PRIORITY);
	t.setName("Shree");
	t.setPriority(0);
	System.out.println(t);
	Integer.parseInt("shree");
  }
}
