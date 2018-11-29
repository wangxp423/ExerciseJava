package com.xp.java.exercise;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/29 0029 16:34
 * @修改人：
 * @修改时间：2018/9/29 0029 16:34
 * @修改备注：
 */
public class TestString {

    public static void main(String[] args) {
        testString();
    }

    public static void testString() {
        String a = "HelloWord";
        String b = "Hello" + new String("Word");
        String c = "HelloWord";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println();
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
    }
}
