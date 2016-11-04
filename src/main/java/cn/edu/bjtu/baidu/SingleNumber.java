package cn.edu.bjtu.baidu;

/**
 * Created by pangchao on 2016/11/3.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 4, 4};
        System.out.println(findSingleNum(array));
    }

    public static int findSingleNum(int[] array) {
        if (array == null)
            return -1;

        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            num = num ^ array[i];
        }

        return num;
    }
}
