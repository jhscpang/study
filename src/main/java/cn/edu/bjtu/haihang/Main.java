package cn.edu.bjtu.haihang;

import java.util.Scanner;

public class Main {

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
            int pos = 0;
            while (pos < len - 1) {
                if (intArray[pos] == 0 && pos != len - 1) { //能量值为0，但是没到终点
                    break;
                } else {
                    pos += intArray[pos];
                }
            }
            if (pos != len - 1) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }

        }
    }

}
