package cn.edu.bjtu.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class TestArrayDeque {

    public static void main(String[] args) {
        LinkedList<Integer> array = new LinkedList<Integer>();
        for (int a : array) {
            System.out.println(a);
        }

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

}
