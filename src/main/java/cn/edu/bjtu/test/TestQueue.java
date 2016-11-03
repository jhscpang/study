package cn.edu.bjtu.test;

import java.util.Deque;
import java.util.LinkedList;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月15日 下午4:17:02
 * @Description: 
 */
public class TestQueue {

	public static void main(String[] args) {
		Deque<String> queue = new LinkedList<String>();
		System.out.println("----offer----");
		queue.offer("111");
		queue.offer("222");
		queue.offer("333");
		for (String string : queue) {
			System.out.println(string);
		}
		System.out.println("----poll----");
		String s = queue.poll();
		System.out.println(s);
	}
}
