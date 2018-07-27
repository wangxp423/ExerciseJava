package com.xp.java.datastructures.set_map.map;


/**
 * @类描述：基于二分搜索树的map
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 10:06
 * @修改人：
 * @修改时间：2018/7/27 0027 10:06
 * @修改备注：
 */
public class BSTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V val) {
        root = add(root, key, val);
    }

    private Node add(Node node, K key, V val) {
        if (null == node) {
            size++;
            return new Node(key, val);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, val);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, val);
        } else {
            node.value = val;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (null != node) {
            root = removeNode(root, key);
            return node.value;
        }
        return null;
    }

    //返回以node为根的二分搜索书的最小元素
    private Node miniNum(Node node) {
        if (node.left == null) return node;
        return miniNum(node.left);
    }

    //删除以Node为根的二分搜索树的最小节点 并返回删除后的新二分搜索树
    private Node removeMini(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMini(node.left);
        return node;
    }

    //删除以node为根 key为节点的元素 并返回删除后的新树
    private Node removeNode(Node node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) {
            node.left = removeNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = removeNode(node.right, key);
        } else { //相等 找到要删除的节点
            if (node.left == null) {
                //找到要删除的节点，并且该节点的左子树为null
                //将该节点的右节点 返回，即赋值给上一个节点左节点
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                //找到要删除的节点，并且该节点的右子树为null
                //将该节点的左节点 返回，即赋值给上一个节点右节点
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点的左右节点都不为null的情况。
            //1,找到该节点的右节点
            //2,找到右节点树下的最小节点(替换节点)(因为只有右子树下的最小节点和删除节点替换才不会影响树结构(二分搜索树满足条件)，也可以是左子树最大节点)
            //3,替换节点的右节点应该为 当前节点的右节点删除最小节点后的树(因为要和该节点替换所以要删除掉)
            //4,替换节点的左节点应该是当前节点的左子树
            //5,将当前节点的左右节点置为null
            Node rightNode = node.right;
            Node swapNode = miniNum(rightNode);
            swapNode.right = removeMini(rightNode);
            swapNode.left = node.left;
            node.left = node.right = null;
            return swapNode;
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return null == node ? null : node.value;
    }

    //返回以Node为根节点的 key所在的节点
    private Node getNode(Node node, K key) {
        if (null == node) return null;
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (null == node) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
