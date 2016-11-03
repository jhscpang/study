package cn.edu.bjtu.sougou;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int len = scanner.nextInt();
            int r = scanner.nextInt();
            int[] array = new int[len];
            for(int i = 0 ; i < len; i++){
                array[i] = scanner.nextInt();
            }
            solution(array, r);
        }
    }

    public static void solution(int[] a, int r) {
        int len = a.length;
        int[] b = new int[len];
        while(r <= len){
            for(int i = 0; i < len; i++){
                int[] tempArray = new int[i + r];
                tempArray[0] = a[i];
                for(int j = 1; j < i+r; j++){
                    tempArray[j] = a[(i + j) % len];
                }
                b[i] = midNum(tempArray);
            }
            r++;
            for(int i = 0; i < len; i++){
                a[i] = b[i];
            }
        }

        System.out.println(a[0]);
    }

    public static int midNum(int[] array){
        Arrays.sort(array);   // 数组从小到大排序
        int len = array.length;
        return array[len/2 + 1];
    }
}
