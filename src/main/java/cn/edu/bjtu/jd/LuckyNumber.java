package cn.edu.bjtu.jd;

/** 
 * @author: pangchao 
 * @date: 2016年9月5日 下午8:30:48
 * @Description: 
 */
public class LuckyNumber {

	public static void main(String[] args) {
		if(args.length <= 1) {
			System.out.println("参数至少为两个");
			System.exit(0);
		}else if(Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[0]) < args.length) {
			System.out.println("输入错误");
			System.exit(0);
		}
		else {
			for(int n = 1; n < Integer.parseInt(args[0]); n++) {
				LuckyNumber.findLuckyNumber(Integer.parseInt(args[n]));
			}
		}
			
	}

	public static void findLuckyNumber(int n) {
		if(f(n) == g(n))
			System.out.println(n);
	}
	
	public static int f(int n) {
		boolean isPos = true;//正数为true，负数为false
		if(n <= 0) {
			n = -n;
			isPos = false;
		}			
		int result = 0;
		while(n > 0) {
			result += n % 10;
			n /= 10;
		} 
		return isPos ? result : - result;
	}
	
	public static int g(int n) {
		String binaryString = Integer.toBinaryString(n);
		int len = binaryString.length();
		int result = 0;
		for(int i = 0; i < len; i++) {
			result += binaryString.charAt(i) - '0';
		}
		return result;
	}
	
}
