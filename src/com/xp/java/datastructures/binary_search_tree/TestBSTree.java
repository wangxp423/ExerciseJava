package com.xp.java.datastructures.binary_search_tree;


import java.util.ArrayList;
import java.util.Random;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/25 0025 10:51
 * @修改人：
 * @修改时间：2018/7/25 0025 10:51
 * @修改备注：
 */
public class TestBSTree {
    public static void main(String[] args) {
        preOrder();
//        preOrderNR();
//        inOrder();
//        postOrder();
//        levelOrder();
//        getMiniAndMax();
//        removeMini();
//        removeMax();
//        removeElement();
    }

    private static void preOrder() {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

//        System.out.println(bst);
    }

    private static void preOrderNR() {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrderNR();
        System.out.println();

//        System.out.println(bst);
    }

    private static void inOrder() {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.inOrder();
        System.out.println();

//        System.out.println(bst);
    }

    private static void postOrder() {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.postOrder();
        System.out.println();

//        System.out.println(bst);
    }

    private static void levelOrder() {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.levelOrder();
        System.out.println();

//        System.out.println(bst);
    }

    private static void getMiniAndMax() {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        System.out.println(bst.getMiniNum());
        System.out.println(bst.getMaxNum());
    }

    private static void removeMini() {
        BSTree<Integer> bsTree = new BSTree<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bsTree.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bsTree.isEmpty()) {
            nums.add(bsTree.removeMini());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");
    }

    private static void removeMax() {
        BSTree<Integer> bsTree = new BSTree<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bsTree.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bsTree.isEmpty()) {
            nums.add(bsTree.removeMax());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");
    }

    private static void removeElement() {
        BSTree<Integer> bst = new BSTree<>();
        Random random = new Random();

        int n = 100;

        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(n));

        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;
        // 打乱order数组的顺序
        shuffle(order);

        // 乱序删除[0...n)范围里的所有元素
        for (int i = 0; i < n; i++)
            if (bst.contains(order[i])) {
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.getSize());
            }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.getSize());
    }

    // 打乱数组顺序
    private static void shuffle(Object[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

}
