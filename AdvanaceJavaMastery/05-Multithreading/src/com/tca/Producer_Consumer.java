package com.tca;


import java.util.LinkedList;

class Resourcee {
	LinkedList<Integer> buffer = new LinkedList<>();
	int capacity = 5;

	public void produce() throws Exception 
	{
		int value = 0;
		while (true) 
		{
			synchronized (this) 
			{
				while (buffer.size() == capacity) 
				{
					wait();
				}
				buffer.add(value);
				System.out.println("Producer Produced:" + value);
				value++;
				notify();
				Thread.sleep(1000);
			}
		}

	}

	public void consume() throws Exception
	{
		while (true) {
			synchronized (this) 
			{
				while (buffer.size() == 0) 
				{
					wait();
				}
				int value = buffer.remove();
				System.out.println("Consumer comsumes" + value);
				notify();
				Thread.sleep(1000);
			}

		}

	}
}

class ProducerThread extends Thread {
	Resourcee res;

	public ProducerThread(Resourcee res) 
	{
		this.res = res;
	}

	public void run()
	{
		try
		{
			res.produce();
		} catch (Exception e) 
		{
			e.printStackTrace();

		}

	}

}

class ConsumerThread extends Thread
{
	Resourcee res;

	public ConsumerThread(Resourcee res) 
	{
		this.res = res;
	}

	public void run() 
	{
		try {
			res.consume();
		} catch (Exception e) 
		{
			e.printStackTrace();

		}
	}
}

public class Producer_Consumer 
{
	public static void main(String[] args) throws InterruptedException {
		Resourcee res = new Resourcee();
		ProducerThread t1 = new ProducerThread(res);
		ConsumerThread t2 = new ConsumerThread(res);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
