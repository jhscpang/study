package cn.edu.bjtu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangchao on 2016/10/14.
 */
public class Testddd {

    private static final List<String> NAMES = new ArrayList<String>() {
        {
            add("pp");
            System.out.println(NAMES);
        }
    };

}
