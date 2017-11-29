package com.yash.threaddemo.main;

class Main{
	public static void main(String[] args) throws InterruptedException {
	    Main m = new Main();
	
	    MeraThread meraThread = new MeraThread(m);
	    meraThread.start();
	    
	    System.out.println("Main Started");
	    synchronized (m) {
	      m.wait();
	    }
	    System.out.println("Main Terminated");
	  }
	
	
	
}

class MeraThread extends Thread{
Main l;
	
public MeraThread(Main m) {
	this.l=m;
}

@Override
	public void run() {
		try {
			System.out.println("MeraThread");
			Thread.currentThread().sleep(2000);
			
			synchronized (l) {
				l.notify();
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
