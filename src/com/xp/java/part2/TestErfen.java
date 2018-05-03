package com.xp.java.part2;

/**
 * 折半查找
 * Created by Wang on 2018/1/16 0016.
 */
public class TestErfen {
    private int binarySearch(int[] arrays,int num){
        int startIndex = 0;
        int endIndex = arrays.length - 1;
        while (startIndex <= endIndex ){
            int middle = (startIndex + endIndex) >>> 1;
            if (num == arrays[middle]){
                return middle;
            } else if (num < arrays[middle]){
                endIndex = middle - 1;
            } else {
                startIndex = middle + 1;
            }
        }
        return - 1;
    }

    public static void main(String[] args){
        int a = 8;
        int[] data = new int[]{1,2,3,4,5,6,7};
        TestErfen erfen = new TestErfen();
        System.out.println(erfen.binarySearch(data,7));
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("a >> 1 = " + (a >> 1));
        System.out.println("a >>> 1 = " + (a >>> 1));
    }
}
