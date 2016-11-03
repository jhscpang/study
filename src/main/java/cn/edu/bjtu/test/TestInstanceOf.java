package cn.edu.bjtu.test;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月20日 下午6:19:54
 * @Description: 
 */
public class TestInstanceOf {
	public static void main(String[] args) {
		long a = 0L;
		Long b = 0L;
		System.out.println(b instanceof Long);
		//System.out.println(a instanceof Long); //语法不支持
	}
}
