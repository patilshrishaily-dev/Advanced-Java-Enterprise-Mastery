package com.tca;

import java.util.Arrays;
import java.util.Random;

class SumThread extends Thread
{
	int start;int end;int a[];int sum;
	public SumThread(int a[],int start,int end)
	{
		this.start=start;
		this.end=end;
		this.a=a;
		this.sum=0;
	}
	public void run()
	{
		for(int i=start;i<=end;i++)
		{
			sum=sum+a[i];
		}
	}
}

public class GenericiSumThread
{

	public static void main(String[] args) throws InterruptedException
	{
	 Random r=new Random();
	 int n=40;
	 int a[]=new int[n];
	 System.out.println("Array is"+Arrays.toString(a));
	 for(int i=0;i<n;i++)
	 {
		 a[i]=r.nextInt()%100;
	 }
	 System.out.println("Array is"+Arrays.toString(a));
	 SumThread t1=new SumThread(a,0,19);
	 SumThread t2=new SumThread(a,20,39);
	 t1.start();
	 t2.start();
	 t1.join();
	 t2.join();
	 
	 int total=t1.sum+t2.sum;
	 System.out.println("Total addition is: "+total);

	}

}
