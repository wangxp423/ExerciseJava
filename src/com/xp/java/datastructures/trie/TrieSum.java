package com.xp.java.datastructures.trie;

import java.util.TreeMap;

/**
 * @类描述：字典树(前缀树) 是一个多叉树
 * 这里实现一个多叉，用来存储单词的实现，然后算出当前单词的权重和
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/2 0002 10:09
 * @修改人：
 * @修改时间：2018/8/2 0002 10:09
 * @修改备注：
 */
public class TrieSum {
    private class Node {
        public int value; //权重
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;
    private int size;

    public TrieSum() {
        root = new Node();
        size = 0;
    }

    //获得Trie中的单词数
    public int getSize() {
        return size;
    }

    //插入一个单词
    public void insert(String words, int val) {
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }


    //根据前缀查出所有包含前缀的单词权重和
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur); //找到前缀的最后一个字符对应的map
    }

    private int sum(Node node) {
        int res = node.value;
        for (Character character : node.next.keySet()) {
            res += sum(node.next.get(character));
        }
        return res;
    }
}
