package cn.edu.bjtu.meituan;

import java.util.Scanner;

public class Main {

    public static void solution(char[] chars) {

        int[] intArray = new int[chars.length]; //用于存放f(i)值
        String[] stringArray = new String[chars.length];
        intArray[0] = 1; //以第x1为末元素的最长递增子序列长度为1

        for (int i = 1; i < chars.length; i++)//循环n-1次
        {
            stringArray[i] = "" + chars[i];
            intArray[i] = 1;//f[i]的最小值为1；
            String temp = "";
            for (int j = 0; j < i; j++)//循环i 次
            {

                if (chars[j] < chars[i] && intArray[j] > intArray[i] - 1) {
                    temp = temp + chars[j];
                    intArray[i] = intArray[j] + 1;//更新f[i]的值。
                }

            }
            stringArray[i] = temp + stringArray[i];
        }
        //打印结果
        int maxLength = 0;
        int maxSize = 0;
        for (int k = 0; k < chars.length; k++) {
            if (maxLength < intArray[k]) {
                maxLength = intArray[k];
                maxSize = k;
            }
        }
        System.out.println(stringArray[maxSize]);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            solution(s.toCharArray());
        }
    }

}
