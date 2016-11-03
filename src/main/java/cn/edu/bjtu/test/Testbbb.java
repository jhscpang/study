package cn.edu.bjtu.test;

import java.util.Scanner;

/**
 * @author: pangchao
 * @date: 2016年9月11日 下午8:35:20
 * @Description:
 */
public class Testbbb {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int low = -90;
		int high = 90;
		int middle = 0;
		int num = 0;
		StringBuffer stringBuffer = new StringBuffer();

		if (scanner.hasNext()) {
			num = scanner.nextInt();
			System.out.println(num);
			if (num > 90 || num < -90) {
				System.out.println("wrong input");
			}

			while ((high - low) > 6) {
				if (num < middle) {
					stringBuffer.append("0");
					high = middle;
					middle = low + (high - low) / 2;
				} else {
					stringBuffer.append("1");
					low = middle;
					middle = low + (high - low) / 2;
				}
			}

			// 最后一位
			if (num >= middle) {
				stringBuffer.append("1");
			} else {
				stringBuffer.append("0");
			}
			System.out.println(stringBuffer.toString());
		}
	}

}
