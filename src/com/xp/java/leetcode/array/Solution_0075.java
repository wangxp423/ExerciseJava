package com.xp.java.leetcode.array;

import com.xp.java.util.TestUtil;

/**
 * @类描述：Leetcode75 颜色分类  0 1 2 分别代表三种颜色
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/11 0011 11:57
 * @修改人：
 * @修改时间：2018/10/11 0011 11:57
 * @修改备注：
 */
public class Solution_0075 {
    //使用计数法，因为只有三种颜色，我们可以声明一个长度为三的数组用来记录各种颜色然后在进行遍历插入赋值。
    //这里的时间复杂度为O(2n)即为O(n)，空间复杂度为O(n)
    public static void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]] += 1;
        }
        int index = 0;
        int color = -1;
        for (int j = 0; j < colors.length; j++) {
            color = j;
            for (int k = 0; k < colors[j]; k++) {
                nums[index++] = color;
            }
        }
    }

    //我们可以尝试用O(n)的时间复杂度 O(1)的空间复杂度来写
    //思路为：用两个指针分别记录: zero代表0结尾的位置,two代表2开头的位置。
    //那么zero-two之间的位置就是1了。这样一次遍历就可以搞定了。
    public static void sortColors1(int[] nums) {
        int zero = -1; //nums[0-zero] = 0
        int two = nums.length; //nums[two - (n-1)] = 2
        for (int i = 0; i < two; ) {//这里不写i++是因为在有些情况下i不需要++
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            } else {
                //这里当i<= zero的时候是不需要进行交换的
                zero++;
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
//        sortColors(nums);
        sortColors1(nums);
        TestUtil.printArray("排序 = ", nums);
    }
}
