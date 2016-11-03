package reflection;

/**
 * Created by pangchao on 2016/10/29.
 */

import java.lang.reflect.Constructor;

public class Demo1 {

    public static void main(String[] args) {
        try {
            //获取Person类的Class对象
            Class clazz = Class.forName("reflection.Person");
            /**
             * 第一种方法创建对象
             */
            //创建对象
            Person p = (Person) clazz.newInstance();
            //设置属性
            p.setName("张三");
            p.setAge(16);
            p.setGender("男");
            System.out.println(p.toString());

            /**
             * 第二种方法创建
             */
            //获取构造方法
            Constructor c = clazz.getDeclaredConstructor(String.class, String.class, int.class);
            //创建对象并设置属性
            Person p1 = (Person) c.newInstance("李四", "男", 20);
            System.out.println(p1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}