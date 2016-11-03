package cn.edu.bjtu.toutiao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            ArrayList<Integer> arrayList = calOrder(n, m);

            for (Integer i : arrayList) {
                System.out.println(i);
            }
           // System.out.println(arrayList.get(m % 10 - 1));

        }
    }

    private static void outVal(int n, int cur, ArrayList<Integer> out, int targetSize) {
        if (cur > n) {
            return;
        }

        if (out.size() == targetSize) {
            return;
        }

        out.add(cur);
        for (int i = 0; i <= 9; i++) {
            outVal(n, cur * 10 + i, out, targetSize);
        }
    }

    private static ArrayList<Integer> calOrder(int n, int targetSize) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            int cur = i;
            outVal(n, cur, out, targetSize);
        }
        return out;
    }

}

