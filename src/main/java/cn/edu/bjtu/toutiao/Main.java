package cn.edu.bjtu.toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//n大了会超时
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<String> arrayList = new ArrayList<String>();

            for(int i = 1; i <= n; i++) {
                arrayList.add(i + "");
            }

            Collections.sort(arrayList);

            System.out.println(arrayList.get(m - 1));

        }
    }
}

class SpellComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        try {
            String s1 = new String(o1.toString());
            String s2 = new String(o2.toString());
            return s1.compareTo(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}