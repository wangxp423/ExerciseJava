package com.xp.java.datastructures.set_map;

import com.xp.java.datastructures.avl.AVLMap;
import com.xp.java.datastructures.avl.AVLSet;
import com.xp.java.datastructures.set_map.map.BSTreeMap;
import com.xp.java.datastructures.set_map.map.LinkedListMap;
import com.xp.java.datastructures.set_map.map.Map;
import com.xp.java.datastructures.set_map.set.BSTSet;
import com.xp.java.datastructures.set_map.set.LinkedListSet;
import com.xp.java.datastructures.set_map.set.Set;

import java.util.ArrayList;

/**
 * @类描述：测试集合和映射
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 9:32
 * @修改人：
 * @修改时间：2018/7/26 0026 9:32
 * @修改备注：
 */
public class TestSetMap {
    public static void main(String[] args) {
//        testBSTSet();
//        testLinkedListSet();
        testSetTime();
//        testLinkedListMap();
//        testBSTreeMap();
        testMapTime();
    }

    private static void testBSTSet() {
        //分别记录《傲慢与偏见》和《双城记》两本的单词数和词汇量
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }

        System.out.println();
    }

    private static void testLinkedListSet() {
        //分别记录《傲慢与偏见》和《双城记》两本的单词数和词汇量
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }

        System.out.println();
    }

    private static double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void testSetTime() {
        //我们会发现树的时间明显比链表时间短
        //链表的时间复杂度为链表长度 n  即为O(n)
        //树的时间复杂度为树的深度h  其中 2的h次幂+1 = n  h=log2(n-1) 所以时间复杂度为O(logn)
        String filename = "C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");
        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");
        System.out.println();

        AVLSet<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVL Set: " + time3 + " s");
        System.out.println();
    }

    private static void testLinkedListMap() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();

    }

    private static void testBSTreeMap() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTreeMap<String, Integer> map = new BSTreeMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();

    }

    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void testMapTime() {
        String filename = "C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt";

        BSTreeMap<String, Integer> bstMap = new BSTreeMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");
        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");
        System.out.println();

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time3 + " s");
        System.out.println();

    }
}
