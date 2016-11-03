package cn.edu.bjtu.sohu;

import java.util.Scanner;

public class Sohu2 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Long number = in.nextLong();
		int k = in.nextInt();
		String string = number.toString();
		int size = string.length();
		int[] arr = new int[size];		
		int cur = 0, pre;
		int result = 0;
		int tmp = size - k;
		for(int i = 0; i < size; i++){
			Character c = string.charAt(i);
			arr[i] = Integer.parseInt(c.toString());
		}
		
		while(k != 0 && cur < size){
			pre = cur - 1;
			while(pre > 0){
				if(arr[pre] <= arr[cur]){
					for(int i = pre; i < size - 1; ++i)
						arr[i] = arr[i+1];
					--cur;
					--k;
					--size;
				}
				--pre;
			}
			++cur;
		}
		
		for(int i = 0; i < tmp; ++i){
			result = result * 10 + arr[i];
		}
		System.out.println(result);
		
	}
	
}
