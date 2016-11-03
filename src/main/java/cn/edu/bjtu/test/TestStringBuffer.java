package cn.edu.bjtu.test;

/**
 * Created by pangchao on 16/9/4.
 */
public class TestStringBuffer {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello world");
        replaceSpace(sb);
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.capacity() == 0)
            return null;
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
