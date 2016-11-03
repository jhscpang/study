package cn.edu.bjtu.sougou;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public int get(int[] a, int r) {
        int[][] temp = new int[a.length][r];
        int b[] = new int[a.length];
        if (a.length <= 0) {
            return -1;
        } else if (!(1 <= r && r <= a.length)) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < r; j++) {
                if (j == 0) {
                    temp[i][j] = a[i];
                } else {
                    temp[i][j] = a[(i + j) % a.length];
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            b[i] = getMiddleNumber(temp[i]);
        }
        if (checkArray(b)) {
            return b[0];
        } else {
            r = r + 1;
            return get(b, r);
        }
    }

    public int getMiddleNumber(int... a) {
        int[] temp = Arrays.copyOf(a, a.length);
        Arrays.sort(temp);
        int small = temp.length / 2 - 1;
        int big = temp.length / 2;
        if (temp.length % 2 == 0) {
            return temp[small >= big ? small : big];
        } else {
            return temp[big];
        }
    }

    public static boolean checkArray(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        if (set.size() == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Main test = new Main();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("收敛数:" + test.get(a, 5));
    }
}
