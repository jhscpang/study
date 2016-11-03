package cn.edu.bjtu.sina;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pangchao on 2016/10/23.
 */
public class Main {

    public static void main(String[] args) {
        String s = "hahhahello";
        System.out.println(solution(s));
    }

    public static String solution(String string) {
        if (string == null || "".equals(string))
            return string;

        char[] array = string.toCharArray();
        StringBuffer sb = new StringBuffer();
        Set<Character> set = new HashSet<>();

        for (char c : array) {
            if (!set.contains(c))
                set.add(c);
        }

        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();
    }
}
