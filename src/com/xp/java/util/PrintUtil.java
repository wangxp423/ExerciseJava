package com.xp.java.util;

/**
 * @类描述：打印工具类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/6 0006 15:44
 * @修改人：
 * @修改时间：2018/8/6 0006 15:44
 * @修改备注：
 */
public class PrintUtil {
    public static void printArray(String name, int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i != array.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
