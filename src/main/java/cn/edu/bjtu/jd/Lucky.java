package cn.edu.bjtu.jd;

/** 
 * @author: pangchao 
 * @date: 2016年9月5日 下午8:10:36
 * @Description: 
 */
public class Lucky {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Lucky.solution(5);
		System.out.println(test(9));
	}
	
	public static int test(int n) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 1;
		return test(n - 1) + test(n - 2);
	}

	public static void solution(int n) {
		if(n <= 0) 
			return;
		int p = 1;
		int result = 0;
		while(n > 0) {
			if(n % 10 == 7)
				result += p;
			p <<= 1;
			n /= 10;
		}
		result += p;
		System.out.println(result - 1);
	}
}
