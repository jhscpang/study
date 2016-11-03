package cn.edu.bjtu.lutou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxValue = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        // 定义初始的数组
        int len = scanner.nextInt();
        int firstIndex = 0;
        int lastIndex = 0;
        int[] inputArray = new int[len];
        int count = 0;
        while (scanner.hasNext()) {
            if (count == 50000) {
                count = 0;
                len = scanner.nextInt();
                firstIndex = 0;
                lastIndex = 0;
                for (int i = 0 ; i < inputArray.length; i++) {
                    inputArray[i] = 0;
                }
                continue;
            } else {
                count++;
            }

            int low = scanner.nextInt();
            int high = scanner.nextInt();
            int num = scanner.nextInt();

            if (low == -1 && high == -1 && num == -1) {
                System.out.println(firstIndex + " " + lastIndex);
                return;
            }
            if (low < 0 || high > len || num > 100) {
                return;
            }
            for (int i = low; i <= high; i++) {
                inputArray[i] += num;
                if (inputArray[i] > maxValue) {
                    firstIndex = i;
                    maxValue = inputArray[i];
                }
                if (inputArray[i] == maxValue) {
                    // 每次都把和maxValue相同的值看作最后出现的位置
                    lastIndex = i;
                }
            }

        }
    }
}