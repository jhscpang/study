package cn.edu.bjtu.sohu;

import java.util.Scanner;

public class River {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			//初始化
			int len = scanner.nextInt();
			if(len <= 0) {
				System.out.println(-1);				
			}else {
				int[] array = new int[len];
				for(int i = 0; i < len; i++) {
					array[i] = scanner.nextInt();
				}
				
				//计算
				int count = 0; //记录跳了几次
				int pos = 0;
				while(pos < len) {
					if(array[pos] <= 0) {
						break;
					} else {
						count ++;
						pos += array[pos];
					}			
				}
				if(pos < len) {
					System.out.println(-1);
				}else {
					System.out.println(count);
				}
			}
		}
	}

}
