package cn.edu.bjtu.haihang;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            //初始化
            String input = scanner.nextLine();
            String[] array = input.split(",");
            int len = array.length;
            int[] intArray = new int[len];
            for (int i = 0; i < len; i++) {
                intArray[i] = Integer.parseInt(array[i]);
            }

            //计算
            if (canCross(intArray))
                System.out.println(-1);
            else
                System.out.println(1);

        }
    }

    public static boolean canCross(int[] stones) {
        if (stones[1] > 1) return false;
        if (stones.length == 2) return true;
        return helper(stones, 1, 1);
    }

    private static boolean helper(int[] arr, int i, int step) {
        if (i == arr.length - 1) return true;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] <= arr[i] + step + 1 && arr[j] >= arr[i] + step - 1) {
                if (helper(arr, j, arr[j] - arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
