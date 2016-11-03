package cn.edu.bjtu.didi;

import java.util.Scanner;
public class TenToM {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] num = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (scanner.hasNextInt()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			if(m > Integer.MAX_VALUE || m < Integer.MIN_VALUE || n <= 0 || n > 16)
				continue;
			
			if(n != 2) {//处理非2进制
				StringBuffer sb = new StringBuffer();
				if(m > 0) {//处理正数
					while (m != 0)
					{
						sb.insert(0, num[m % n]);
						m = m / n;
					}
					System.out.println(sb.toString());
				}else {//处理负数
					int t = -m;
					while (t != 0)
					{
						sb.insert(0, num[t % n]);
						t = t / n;
					}
					sb.insert(0, "-");
					System.out.println(sb.toString());
				}
				
			}else {//处理2进制
				System.out.println(Integer.toBinaryString(m));
			}
			
		}

	}

}
