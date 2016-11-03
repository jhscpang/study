package cn.edu.bjtu.test;

/**
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年7月10日 下午12:10:34
 * @Description:
 */
public class TestClassInitOrder {

	public static void main(String[] args) {
		Son son = new Son();
		// 注意，初始化块和成员变量谁放在前面谁先被加载
		// 7-->子类静态初始化块 
		// 8-->子类静态成员变量
		// 1-->父类初始化块
		// 4-->父类成员变量
		// 5-->父类构造方法
		// 6-->子类初始化块
		// 9-->子类成员变量
		// 10-->子类构造方法
	}

}

class Farther {
	{
		System.out.println("1-->父类初始化块");
	}

	// static {
	// System.out.println("2-->父类静态初始化块");
	// }

	// private static String aString = print();

	private String bString = print2();

	// public static String print() {
	// System.out.println("3-->父类静态成员变量");
	// return "aString";
	// }

	public String print2() {
		System.out.println("4-->父类成员变量");
		return "bString";
	}

	public Farther() {
		System.out.println("5-->父类构造方法");
	}
}

class Son extends Farther {
	
	private String dString = print4();
	
	{
		System.out.println("6-->子类初始化块");
	}

	private static String cString = print3();

	static {
		System.out.println("7-->子类静态初始化块");
	}

	public static String print3() {
		System.out.println("8-->子类静态成员变量");
		return "cString";
	}

	public String print4() {
		System.out.println("9-->子类成员变量");
		return "dString";
	}

	public Son() {
		System.out.println("10-->子类构造方法");
	}
}
