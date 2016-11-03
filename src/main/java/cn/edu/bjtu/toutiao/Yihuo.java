package cn.edu.bjtu.toutiao;

import java.util.Scanner;

public class Yihuo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {

			// init
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < array.length; i++) {
				array[i] = scanner.nextInt();
			}

			// calculate
			long count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					long value = array[i] ^ array[j];
					if (value > m)
						count++;
				}
			}

			// output
			System.out.println(count);
		}

	}

}
