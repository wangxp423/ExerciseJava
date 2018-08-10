package com.xp.java.datastructures.black_red_tree;

import com.xp.java.datastructures.avl.AVLTree;
import com.xp.java.datastructures.set_map.FileOperation;
import com.xp.java.datastructures.set_map.map.BSTreeMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/7 0007 15:06
 * @修改人：
 * @修改时间：2018/8/7 0007 15:06
 * @修改备注：
 */
public class TestBRTree {
    public static void main(String[] args) {
//        testWords();
        //执行时间有点长，三个树结构在我电脑平均运行时间在60S。
        //看时间我们会发现 AVL运行时间竟然比BST时间还要长，而RBTree的时间优势也就那么一丢丢。
//        testTime1();

        //在time2 中的两千万的数据的插入中 我的电脑运行RBTree 的时间竟然 大于 AVL树的时间。有两秒的差距
        //当数据增加到 两千五百万的时候 我电脑 AVL 21秒  RBTree 18秒  说明 RBTree是有优势的。
        testTime2();


        //总结：
        //BSTree(二分搜索树) 在完全随机数插入的情况下。他有可能保持自己树的平衡性，所以在time1中时间差别并不大
        //但是在一些极端情况下有可能会出现单链表的情况，所以就会影响效率。

        //AVLTree(AVL平衡树) AVL是平衡树 但是虽然在时间复杂度都是0(logn)的情况下，因为是平衡的。所以效率更高
        //但是他在维护平衡的时候，做了很多操作。所以在add 和 remove 上的效率稍微低点，不如RBTree，get效率比RBTree高点

        //RBTree(红黑树，也可以叫平衡B树) 因为在红黑树中。左右两棵树中走到底的黑色节点树一样。所以红黑树的平衡性还是不错的。
        //而他们维护平衡性操作比AVL简单。所以add remove效率更好，get效率因为平衡性不错。也之比AVL差一点点
        //所以红黑树是综合效率最高的数据结构，因此我们能看到在TreeSet TreeMap的底层实际都是红黑树实现
    }

    private static void testWords() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            //Test BSTree二分搜索树
            long startTime = System.nanoTime();
            BSTreeMap<String, Integer> bsTreeMap = new BSTreeMap<>();
            for (String word : words) {
                if (bsTreeMap.contains(word))
                    bsTreeMap.set(word, bsTreeMap.get(word) + 1);
                else
                    bsTreeMap.add(word, 1);
            }
            for (String word : words)
                bsTreeMap.contains(word);

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");
            System.out.println();

            //Test AVLTree
            startTime = System.nanoTime();
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word))
                    avlTree.set(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }
            for (String word : words)
                avlTree.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
            System.out.println();

            //Test RBTree
            startTime = System.nanoTime();
            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word))
                    rbTree.set(word, rbTree.get(word) + 1);
                else
                    rbTree.add(word, 1);
            }
            for (String word : words)
                rbTree.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");
            System.out.println();

        }
    }

    private static void testTime1() {
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            testData.add(random.nextInt(Integer.MAX_VALUE));

        // Test BST
        long startTime = System.nanoTime();

        BSTreeMap<Integer, Integer> bst = new BSTreeMap<>();
        for (Integer x : testData)
            bst.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");


        // Test AVL
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData)
            avl.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }

    private static void testTime2() {
        int n = 22000000;

        ArrayList<Integer> testData = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            testData.add(i);

        // Test BST 这里之所以注释掉二分搜索树，是因为 在有序的情况下，二分搜索树最坏情况发生会变成一个链表。没有对比意义，这也是他的劣势的原因。
//        long startTime = System.nanoTime();
//
//        BSTreeMap<Integer, Integer> bst = new BSTreeMap<>();
//        for (Integer x: testData)
//            bst.add(x, null);
//
//        long endTime = System.nanoTime();
//
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BST: " + time + " s");


        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }

}
