package cn.edu.bjtu.baidu;

/**
 * Created by pangchao on 2016/11/4.
 */
public class Coin {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i <= 20; i++) {
            result += solution(100 - 5 * i);
        }
        System.out.println(result);
    }

    public static int solution(int x) {
        if (x == 0 || x == 1)
            return 1;
        if (x % 2 == 0)
            return x / 2;
        else
            return x / 2 + 1;
    }
}
