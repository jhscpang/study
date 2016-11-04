package cn.edu.bjtu.baidu;

/**
 * Created by pangchao on 2016/11/3.
 */
public class Fibonacii {

    public static void main(String[] args) {
        System.out.println(fibonacii1(4));
    }

    public static long fibonacii(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacii(n - 1) + fibonacii(n - 2);
    }

    public static long fibonacii1(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        long one = 1;
        long two = 0;
        long m = 0;
        for(int i = 2; i <= n; i++) {
            m = one + two;
            two = one;
            one = m;
        }
        return m;
    }
}
