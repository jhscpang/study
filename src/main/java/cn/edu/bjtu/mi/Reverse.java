package cn.edu.bjtu.mi;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		String data = null;
		while (in.hasNext()) {
			//read
			data = in.nextLine();
			//split
			String[] word = data.split(" ");
			//reverse
			StringBuilder sb = new StringBuilder();
			for(int i = word.length - 1; i >= 0; i--){
				sb.append(word[i]);
				if(i != 0){
					sb.append(" ");
				}
			}
			//result
			System.out.println(sb.toString());
		}
	}
}