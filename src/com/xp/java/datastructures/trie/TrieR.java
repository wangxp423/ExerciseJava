package com.xp.java.datastructures.trie;

import java.util.TreeMap;

/**
 * @类描述：字典树(前缀树) 是一个多叉树, TrieR 是Trie in Recursion使用递归实现一个Trie
 * 这里实现一个多叉，用来存储单词的实现
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/2 0002 10:09
 * @修改人：
 * @修改时间：2018/8/2 0002 10:09
 * @修改备注：
 */
public class TrieR {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public TrieR() {
        root = new Node();
        size = 0;
    }

    //获得Trie中的单词数
    public int getSize() {
        return size;
    }

    //插入一个单词
    public void add(String words) {
        add(root, words, 0);
    }

    //向以node为根的Trie中添加word[index...end]，递归算法
    private void add(Node node, String words, int index) {
        if (index == words.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }
        char c = words.charAt(0);
        if (node.next.get(c) == node) {
            node.next.put(c, new Node());
        }
        add(node.next.get(c), words, index + 1);
    }

    //查询单词word是否在Trie中
    public boolean contains(String words) {
        return contains(root, words, 0);
    }

    public boolean contains(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        } else {
            return contains(node.next.get(c), word, index + 1);
        }
    }

    //查询在Trie中是否有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        return isPrefix(root, prefix, 0);
    }

    public boolean isPrefix(Node node, String prefix, int index) {
        if (index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        } else {
            return contains(node.next.get(c), prefix, index + 1);
        }
    }
}
