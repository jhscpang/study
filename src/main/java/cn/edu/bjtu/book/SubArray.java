package cn.edu.bjtu.book;

/**
 * Created by pangchao on 2016/11/4.
 */
public class SubArray {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findMaxSubArraySum(array));
    }

    public static int findMaxSubArraySum(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int curSum = 0;
        int greatestSum = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (curSum < 0)
                curSum = array[i];
            else
                curSum += array[i];

            if (curSum > greatestSum)
                greatestSum = curSum;
        }

        return greatestSum;
    }
}
