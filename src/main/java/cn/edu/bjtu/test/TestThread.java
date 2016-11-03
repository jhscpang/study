package cn.edu.bjtu.test;

/**
 * Created by pangchao on 16/8/11.
 */
public class TestThread {

	public static void main(String[] args) {
		new Thread1().start();
	}
	
}

class Thread1 extends Thread {
	@Override
	public void run(){
		System.out.print("Thread1 run");
	}
}