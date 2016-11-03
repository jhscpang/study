package cn.edu.bjtu.test;

import java.util.Deque;
import java.util.LinkedList;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月15日 下午4:14:08
 * @Description: 
 */
public class TestStack {

	/** 
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		System.out.println("----push----");
		stack.push("1111");
		stack.push("2222");
		stack.push("3333");
		for (String string : stack) {
			System.out.println(string);
		}
		System.out.println("----pop----");
		String s = stack.pop();
		System.out.println(s);
	}

}
