package com.xp.java.datastructures.trie;

/**
 * @类描述：字典树(前缀树) 是一个多叉树，用数组来作为Node的数据存储
 * 这里实现一个多叉，用来存储单词的实现
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/2 0002 10:09
 * @修改人：
 * @修改时间：2018/8/2 0002 10:09
 * @修改备注：
 */
public class TrieArray {
    private class Node {
        public boolean isWord;
        public Node[] next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26]; //26个英文字母，暂时不区分大小写,之所以能用数组，也在于字符之间的特殊性。可以用减来确定索引位置
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public TrieArray() {
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
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
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
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }
}
