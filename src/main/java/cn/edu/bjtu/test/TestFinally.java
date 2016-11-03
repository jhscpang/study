package cn.edu.bjtu.test;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月2日 下午11:25:39
 * @Description: 
 */
public class TestFinally {

	/** 
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		System.out.println(test());
		System.out.println(test1());		
	}

	static int test() {
		int x = 1;
		try {
			return x;
		} finally {
			x++;
		}
	} 
	
	static int test1() {
		try {
			return 1;
		} finally {
			return 2;
		}
	} 
}
