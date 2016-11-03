package cn.edu.bjtu.mi;

/**
 * Created by pangchao on 16/10/7.
 */
public class Split {

    public static void main(String[] args) {
        String s = " aaa";
        String[] array = s.split(" ", -10);
        for(String a : array) {
            System.out.println("-->" + a + "<--");
        }
    }

}
