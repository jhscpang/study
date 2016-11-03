package cn.edu.bjtu.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: pangchao
 * @date: 2016年9月11日 下午7:34:28
 * @Description:
 */
public class Testaaa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt())
		{
			System.out.println(solution(scanner.nextInt()));		
		}
	}

	public static int solution(int num) {
		if (num <= 0)
			return 0;
		int result = 0;
		for (int i = 0; i < num; i++) {
			if (isPrimeNumber(i)) {
				if (isPrimeNumber(num - i)) {
					result++;
				}
			}
		}
		return (result + 1) / 2;
	}

	public static boolean isPrimeNumber(int num) {
		if (num <= 1) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		int sqrt = (int) Math.sqrt(num);
		if (num % 2 == 0)
			return false;
		for (int i = 3; i <= sqrt; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
