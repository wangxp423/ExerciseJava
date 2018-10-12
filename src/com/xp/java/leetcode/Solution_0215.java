package com.xp.java.leetcode;

/**
 * @类描述：Leetcode 215 数组中第K个最大元素
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
        while (true) {
            int mark = quickSortOne(nums, 0, nums.length - 1, index);
            if (mark == index) return nums[index];
            if (mark < index) quickSortOne(nums, mark + 1, nums.length - 1, index);
            if (mark > index) quickSortOne(nums, 0, mark - 1, index);
        }
    }

    //一次快排，返回标志位
    //k为第几大的数值，那么他在数组中的位置index = nums.lenggh-k
    //我们以index为标志位，进行快速排序，每一次返回当前index标志位在数组中的真实位置
    //然后将index和真实位置进行比较，然后再次进行区间快排。直到标志位在他改在的位置。
    private static int quickSortOne(int[] nums, int start, int end, int mark) {
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] > nums[mark]) {
                right--;
            }
            while (left < right && nums[left] <= nums[mark]) {
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[mark];
        nums[mark] = nums[right];
        nums[right] = temp;
        return right;
    }

    //标准快排
    private static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int left = start;
        int right = end;
        int mark = start;
        while (left < right) {
            while (left < right && nums[right] > nums[mark]) {
                right--;
            }
            while (left < right && nums[left] <= nums[mark]) {
                left++;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        int temp = nums[mark];
        nums[mark] = nums[right];
        nums[right] = temp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums2 = {3, 6, 7, 4, 2, 8, 9, 1};
//        quickSort(nums2, 0, nums2.length - 1);
//        TestUtil.printArray("快速排序 = ", nums2);
//        System.out.println("k = " + findKthLargest(nums,2));
        System.out.println("k = " + findKthLargest1(nums2, 3));
    }
}
