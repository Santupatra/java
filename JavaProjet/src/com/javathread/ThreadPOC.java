package com.javathread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPOC {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

		for (int i = 0; i < 20; i++) {
			MyThread m1= new MyThread(""+i);
			System.out.println(i +" thread");
			executor.execute(m1);
		}
		executor.shutdownNow();
		
		
		/*
		 * Thread t1 = new Thread(new MyThread()); System.out.println("Start");
		 * t1.start(); System.out.println("Stop");
		 */
	}

}

class MyThread implements Runnable {

	private String tId;

	public MyThread(String tId) {
		super();
		this.tId = tId;
	}

	@Override
	public void run() {
		try {
			System.out.println(tId);
			TimeUnit.SECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
