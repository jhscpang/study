package cn.edu.bjtu.didi;

import java.util.Arrays;
import java.util.Scanner;

public class RandomSum {
    //数组子串和
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);
            int totalResult = 0;
            for(int i = 0; i < array.length; i++){
                totalResult += count(array, m, i);
            }

            System.out.println(totalResult);
        }
    }

    public static int count(int[] array, int sum, int i){
        int res = 0;
        sum -= array[i];
        //和刚好等于sum
        if(sum == 0){
            res += 1;
        }else if(sum < 0){
            return 0;
        }else{
            for(int j = i + 1; j < array.length; j++){
                res += count(array, sum, j);
            }
        }
        return res;
    }
}
