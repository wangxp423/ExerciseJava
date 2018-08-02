package com.xp.java.datastructures.trie;

import java.util.TreeMap;

/**
 * @类描述：字典树(前缀树) 是一个多叉树
 * 这里实现一个多叉，用来存储单词的实现
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/2 0002 10:09
 * @修改人：
 * @修改时间：2018/8/2 0002 10:09
 * @修改备注：
 */
public class Trie {
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

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获得Trie中的单词数
    public int getSize() {
        return size;
    }

    //插入一个单词
    public void add(String words) {
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    //查询单词word是否在Trie中
    public boolean contains(String words) {
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //查询在Trie中是否有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
