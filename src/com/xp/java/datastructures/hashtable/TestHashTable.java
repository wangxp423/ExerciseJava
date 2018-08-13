package com.xp.java.datastructures.hashtable;

import com.xp.java.datastructures.avl.AVLTree;
import com.xp.java.datastructures.red_black_tree.RBTree;
import com.xp.java.datastructures.set_map.FileOperation;
import com.xp.java.datastructures.set_map.map.BSTreeMap;

import java.util.ArrayList;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/13 0013 10:41
 * @修改人：
 * @修改时间：2018/8/13 0013 10:41
 * @修改备注：
 */
public class TestHashTable {
    public static void main(String[] args) {
        testHashTable();
//        testWords();

    }

    private static void testHashTable() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            //Test HashTable
            long startTime = System.nanoTime();
            //设置一个大于单词总数的最近的按个素数。当然你也可以设置一个很小的素数测试一下。不传参数我们实现了自动扩容缩荣
//            HashTable<String, Integer> hashTable = new HashTable<>(131071);
//            HashTable<String, Integer> hashTable = new HashTable<>(7);
            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word))
                    hashTable.set(word, hashTable.get(word) + 1);
                else
                    hashTable.add(word, 1);
            }
            for (String word : words)
                hashTable.contains(word);

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
            System.out.println();
        }
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


            //Test HashTable
            startTime = System.nanoTime();
            HashTable<String, Integer> hashTable = new HashTable<>(131071);
            for (String word : words) {
                if (hashTable.contains(word))
                    hashTable.set(word, hashTable.get(word) + 1);
                else
                    hashTable.add(word, 1);
            }
            for (String word : words)
                hashTable.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
            System.out.println();

        }
    }

}
