package cn.edu.bjtu.tencent;

/**
 * Created by pangchao on 2016/11/3.
 */
public class SortRelevance {
    public static int[] array = {1, 3, 5, 2, 6, 9, 8, 4, 7};

    //递增快速排序
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int povit = patition(array, low, high);
            quickSort(array, low, povit - 1);
            quickSort(array, povit + 1, high);
        }
    }

    private static int patition(int[] array, int low, int high) {
        int povit = array[low];
        while (low < high) {
            while (low < high && array[high] >= povit)
                high--;
            array[low] = array[high];
            while (low < high && array[low] <= povit)
                low++;
            array[high] = array[low];
        }
        array[low] = povit;
        return low;
    }

    //递增冒泡排序
    public static void bubbleSort(int[] array) {
        if (array == null)
            return;

        int len = array.length;
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = len - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {  //若逆序，则交换
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    //递增简单选择排序
    public static void selectSort(int[] array) {
        if (array == null)
            return;

        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }



    public static void printArray(int[] array) {
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i != array.length - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        printArray(array);
        //quickSort(array, 0, array.length - 1);
        //bubbleSort(array);
        selectSort(array);
        printArray(array);
    }
}
