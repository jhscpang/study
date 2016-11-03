package cn.edu.bjtu.test;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月12日 下午6:29:02
 * @Description: 
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	/**
	 * @paramargs
	 */
	private int j;
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		TestLock tt = new TestLock();
		for(int i=0;i<2;i++)
		{
			new Thread(tt.new Adder()).start();
			new Thread(tt.new Subtractor()).start();
		}
	}

	private class Subtractor implements Runnable {
		public void run() {
			// TODO Auto-generated methodstub while(true)
			{
				/*
				 * synchronized (ThreadTest.this) { System.out.println("j--="+
				 * j--); //这里抛异常了,锁能释放吗? }
				 */ lock.lock();
				try {
					System.out.println("j--=" + j--);
				} finally {
					lock.unlock();
				}
			}
		}
	}

	private class Adder implements Runnable {
		public void run() {
			// TODO Auto-generated methodstub while(true)
			{
				/*
				 * synchronized (ThreadTest.this) { System.out.println("j++="+
				 * j++); }
				 */
				lock.lock();
				try {
					System.out.println("j++=" + j++);
				} finally {
					lock.unlock();
				}
			}
		}
	}
}
