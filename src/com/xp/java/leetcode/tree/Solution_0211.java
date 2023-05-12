package com.xp.java.leetcode.tree;

import java.util.TreeMap;

/**
 * @类描述：Leetcode211 添加与搜索单词 - 数据结构设计
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/2 0002 11:38
 * @修改人：
 * @修改时间：2018/8/2 0002 11:38
 * @修改备注：
 */
public class Solution_0211 {
    class Node {
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

    class WordDictionary {
        public Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            cur.isWord = true;

        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return match(root, word, 0);
        }

        private boolean match(Node node, String words, int index) {
            if (index == words.length()) {
                return node.isWord;
            }
            char c = words.charAt(index);
            if (c != '.') {
                if (node.next.get(c) == null) {
                    return false;
                } else {
                    return match(node.next.get(c), words, index + 1);
                }
            } else {
                for (char nextChar : node.next.keySet()) {
                    if (match(node.next.get(nextChar), words, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
