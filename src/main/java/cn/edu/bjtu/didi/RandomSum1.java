package cn.edu.bjtu.didi;

import java.util.Scanner;

public class RandomSum1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {

			// init
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}

			int[] sortedArray = quickSort(array);
			int totalResult = 0;
			for(int i = 0; i < array.length; i++){
				totalResult += count(sortedArray, m, i);
			}

			System.out.println(totalResult);
		}

	}

	public static int count(int[] array, int sum, int i){
		int res = 0;
        //sum -= array[i];
		//和刚好等于sum
		if(i > array.length){
			return 0;
		}
		if(0 == sum){
			res += 1;
		}else if(sum < 0){
			return 0;
		}else{
			for(int j = i + 1; j < array.length; j++){
				res += count(array, sum - array[i], j);
			}
		}
		return res;
	}

	public static int[] quickSort(int[] array) {
		if (array != null) {
			quickSort(array, 0, array.length - 1);
		}
		return array;
	}

	private static void quickSort(int[] array, int beg, int end) {
		if (beg >= end || array == null)
			return;
		int p = partition(array, beg, end);
		quickSort(array, beg, p - 1);
		quickSort(array, p + 1, end);
	}

	private static int partition(int[] array, int beg, int end) {
		int last = array[end];
		int i = beg - 1;
		for (int j = beg; j <= end - 1; j++) {
			if (array[j] <= last) {
				i++;
				if (i != j) {
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
				}
			}
		}
		if ((i + 1) != end) {
			array[i + 1] = array[i + 1] ^ array[end];
			array[end] = array[i + 1] ^ array[end];
			array[i + 1] = array[i + 1] ^ array[end];
		}
		return i + 1;
	}

}
