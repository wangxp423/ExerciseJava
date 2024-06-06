package com.xp.java;

//一些java 面试题
public class TestInterview {
    static class ValHold {
        public int i = 10;
    }

    public void amethod() {
        int i = 99;
        ValHold v = new ValHold();
        v.i = 30;
        another(v, i);
        System.out.println(v.i);
    }

    public void another(ValHold v, int i) {
        i = 0;
        v.i = 20;
        ValHold vh = new ValHold();
        v = vh;
        System.out.println(v.i + "" + i);
    }

    //字符串考察
    public static void testConcat() {
        String product = "Pen";
        product.toLowerCase();
        product.concat(" BOX".toLowerCase());
        System.out.println(product);
        System.out.println(product.substring(4, 6));
    }

    public static int weiSum() {
        int a = 4;
        int result = a++ + 4 << 2;
        return result;
    }

    public static String fun(String s) {
        return s.length() < 0 ? (fun(s.substring(1) + s.charAt(0))) : "";
    }

    public static void main(String[] args) {
        TestInterview outer = new TestInterview();
        outer.amethod();
//        testConcat();
        System.out.println(weiSum());
    }
}
