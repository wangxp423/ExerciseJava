package com.xp.java.datastructures.trie;

import com.xp.java.datastructures.set_map.FileOperation;
import com.xp.java.datastructures.set_map.set.BSTSet;
import com.xp.java.datastructures.set_map.set.Set;

import java.util.ArrayList;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/2 0002 10:36
 * @修改人：
 * @修改时间：2018/8/2 0002 10:36
 * @修改备注：
 */
public class TestTrie {
    public static void main(String[] args) {
        //同样读取《pride-and-prejudice.txt》(傲慢与偏见)所有单词，然后查看单词数
        testSetTime();
        testTrieTime();
        //对比我们发现 Trie 是比 二分搜索树快那么一点点，但是因为这个单词数太小。
        // 如果非常大，几百万量级，会发现Trie的搜索跟数量没有关系，只跟单词长度有关
        testTrieHashTime();
        //这里我们就能看出来TreeMap 和 HashMap的计算优势了。HashMap明显比TreeMap快不少。
        testTrieArrayTime();
        //用数组实现Trie，我们发现效率更高，速度更快，因为本身数组就是查询效率最高的数据结构。
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

    private static void testSetTime() {
        //我们会发现树的时间明显比链表时间短
        //链表的时间复杂度为链表长度 n  即为O(n)
        //树的时间复杂度为树的深度h  其中 2的h次幂+1 = n  h=log2(n-1) 所以时间复杂度为O(logn)
        String filename = "C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();
    }

    private static void testTrieTime() {
        String filename = "C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt";
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            Trie trie = new Trie();
            for (String word : words)
                trie.add(word);
            System.out.println("Total different words: " + trie.getSize());
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("Trie: " + time + " s");

        System.out.println();
    }

    private static void testTrieHashTime() {
        String filename = "C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt";
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            TrieHash trie = new TrieHash();
            for (String word : words)
                trie.add(word);
            System.out.println("Total different words: " + trie.getSize());
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("TrieHash: " + time + " s");

        System.out.println();
    }

    private static void testTrieArrayTime() {
        String filename = "C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt";
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            TrieArray trie = new TrieArray();
            for (String word : words)
                trie.add(word);
            System.out.println("Total different words: " + trie.getSize());
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("TrieArray: " + time + " s");

        System.out.println();
    }

}
