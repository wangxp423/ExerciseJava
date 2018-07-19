package com.xp.java.array;

/**
 * @类描述：测试数组类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/18 0018 11:23
 * @修改人：
 * @修改时间：2018/7/18 0018 11:23
 * @修改备注：
 */
public class TestArray {
    public static void main(String[] args) {
//        testArray();
        testArrayT();

    }

    private static void testArray() {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
    }

    private static void testArrayT() {
        ArrayT<Integer> array = new ArrayT();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        System.out.println(array);
    }

}
