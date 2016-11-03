package cn.edu.bjtu.wanmei;

import java.util.Scanner;

public class Main {

    private final static int MAX_FLOOR = 10000;
    private final static int MAX_BALL = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int floor = scanner.nextInt();
            int glass = scanner.nextInt();

            System.out.println(cal(floor, glass));
        }
    }

    public static int cal(int floor, int glass) {
        if (glass < 1 || floor < 1) return -1;    //错误输入

        if (glass == 1) return floor - 1;        //去掉一些trivial case
        if (floor == 1) return 0;

        int[][] Array = new int[MAX_BALL][MAX_FLOOR];
        int i, j, r;
        int temp, min;

        for (i = 0; i <= glass; i++) Array[i][0] = Array[i][1] = 0;    //F(1,k)=F(0,k)=0
        for (j = 2; j <= floor; j++) Array[1][j] = j - 1;            //F(n,1)=n-1

     /*
     状态转移方程：
     F(n,k)=min{max{F(r,k-1)+1, F(n-r,k)+1}, 1<=r<=n}
     */
        for (i = 2; i <= glass; i++)
            for (j = 2; j <= floor; j++) {
                min = Integer.MAX_VALUE;
                for (r = 1; r <= j; r++) {
                    temp = Math.max(Array[i - 1][r], Array[i][j - r]) + 1;
                    if (temp < min)
                        min = temp;
                }
                Array[i][j] = min;
            }

        return Array[glass][floor];//F(n,k)
    }
}
