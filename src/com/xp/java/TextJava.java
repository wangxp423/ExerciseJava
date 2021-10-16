package com.xp.java;

//一些基础题
public class TextJava {
    //字符串考察
    public static void testConcat() {
        String product = "Pen";
        product.toLowerCase();
        product.concat(" BOX".toLowerCase());
        System.out.println(product);
        System.out.println(product.substring(4, 6));
    }

    /*****************位运算*****************/
    public static void rightOne2Zero(int x) {
        int y = 0;
        y = x & (x - 1);
        System.out.println(y);
    }

    //统计1的位数有几个
    public static void sumOneCount(int x) {
        int count = 0;
        while (x > 0) {
            x = x & (x - 1);
            count++;
        }
        System.out.println(count);
    }

    //反转二进制并且得到反转后的结果，如果是32位反转 补齐位数，从32长度循环
    public static void revertBit(int n) {
        String binary = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result = (result << 1) + (n & 1);
            n = n >> 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
//        testConcat();
//        rightOne2Zero(3);
//        sumOneCount(8);
        revertBit(10);
    }

}
