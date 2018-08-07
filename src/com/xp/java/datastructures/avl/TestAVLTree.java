package com.xp.java.datastructures.avl;

import com.xp.java.datastructures.set_map.FileOperation;

import java.util.ArrayList;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/7 0007 15:06
 * @修改人：
 * @修改时间：2018/8/7 0007 15:06
 * @修改备注：
 */
public class TestAVLTree {
    public static void main(String[] args) {
        testWords();
    }

    private static void testWords() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:\\forwork\\MyGithub\\ExerciseJava\\src\\com\\xp\\java\\datastructures\\set_map\\doc\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> tree = new AVLTree<>();
            for (String word : words) {
                if (tree.contains(word))
                    tree.set(word, tree.get(word) + 1);
                else
                    tree.add(word, 1);
            }

            System.out.println("Total different words: " + tree.getSize());
            System.out.println("Frequency of PRIDE: " + tree.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + tree.get("prejudice"));

            System.out.println("is BST : " + tree.isBST());
            System.out.println("is Balanced : " + tree.isBalance());
        }

        System.out.println();

    }
}
