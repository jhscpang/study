package cn.edu.bjtu.test;

import java.util.LinkedList;
import java.util.ListIterator;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月13日 上午10:21:16
 * @Description: 
 */
public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.add("111");
		l.add("222");
		ListIterator<String> listIterator = l.listIterator();
		listIterator.next();
		l.add("333");
		for (String string : l) {
			System.out.println(string);
		}
	}
}
