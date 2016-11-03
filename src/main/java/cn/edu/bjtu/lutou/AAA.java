package cn.edu.bjtu.lutou;

/**
 * Created by pangchao on 2016/10/19.
 */
public class AAA extends House{

    static String a = "bbb";

    public static void main(String[] args) {

        int i = 1;
        i = (i++);
        System.out.println(i);
    }
}


class House {
    private String a = "aaa";

    public  void get() {
        System.out.println(a);
    }
}