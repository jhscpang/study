package cn.edu.bjtu.tencent;

/**
 * Created by pangchao on 2016/11/3.
 */
//问题描述：给定一个整数，输出这个整数转换成二进制数后1的个数
public class CountOne {
    public static void main(String[] args) {
        int num = 15;
        System.out.println(solution(num));
    }

    public static int solution(int num) {
        int count = 0;

        while(num > 0) {
            num = (num - 1) & num;
            count ++;
        }

        return count;
    }
}
