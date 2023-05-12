package com.xp.java.leetcode.array;

/**
 * @类描述：Leetcode215 数组中第K个最大元素
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/12 0012 10:00
 * @修改人：
 * @修改时间：2018/10/12 0012 10:00
 * @修改备注：
 */
public class Solution_0215 {
    //用一个快排时间复杂度O(nlogn)
    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    //根据快速排序的思路，如果我们将标志位指定为k，根据标志位来进行快排，不一定需要快排所有数据。
    public static int findKthLargest1(int[] nums, int k) {
        int index = nums.length - k;
        int start = 0, end = nums.length - 1;
        while (true) {
            int mark = quickSortOne(nums, start, end);
            if (mark == index) return nums[index];
            if (mark < index) start = mark + 1;
            if (mark > index) end = mark - 1;
        }
    }

    //最坏情况其实也是进行了一次快排
    //一次快排，返回标志位
    //k为第几大的数值，那么他在数组中的位置index = nums.lenggh-k
    //返回标志位如果小于index。那么说明这个index在标志位和end区间然后再次进行快排。以此类推
    public static int quickSortOne(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int mark = nums[start];
        while (left < right) {
            while (left < right && nums[right] > mark) {
                right--;
            }
            while (left < right && nums[left] <= mark) {
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[start];
        nums[start] = nums[left];
        nums[left] = temp;
        return left;
    }

    //标准快排
    public static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int left = start;
        int right = end;
        int mark = nums[start]; //选择一个数 作为标志位
        while (left < right) {
            while (left < right && nums[right] > mark) {
                right--;
            }
            while (left < right && nums[left] <= mark) {
                left++;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        int temp = nums[start];
        nums[start] = nums[right];
        nums[right] = temp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums2 = {3, 6, 7, 4, 2, 8, 9, 1};
        int[] nums3 = {-1, -1};
        int[] nums4 = {5, 2, 4, 1, 3, 6, 0};
//        quickSort(nums2, 0, nums2.length - 1);
//        quickSort(nums4, 0, nums4.length - 1);
//        TestUtil.printArray("快速排序 = ", nums4);
//        System.out.println("k = " + findKthLargest(nums,2));
        System.out.println("k = " + findKthLargest1(nums, 2));
        System.out.println("k = " + findKthLargest1(nums1, 4));
        System.out.println("k = " + findKthLargest1(nums2, 3));
        System.out.println("k = " + findKthLargest1(nums3, 2));
        System.out.println("k = " + findKthLargest1(nums4, 4));
    }
}
