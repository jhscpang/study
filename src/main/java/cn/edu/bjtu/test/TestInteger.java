package cn.edu.bjtu.test;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月15日 下午12:32:14
 * @Description: 
 */
public class TestInteger {

	/** 
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 =Integer.valueOf(59);
		Integer i04 = new Integer(59);
		System.out.println(i01== i02);
		System.out.println(i01== i03);
		System.out.println(i03== i04);
		System.out.println(i02== i04);
		
		String aString = "123a";
		System.out.println(Integer.parseInt(aString));
	}

}
