package com.xp.java.datastructures.avl;

import java.util.ArrayList;

/**
 * @类描述：AVL 树 ，AVL也满足二分搜索树的条件
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/25 0025 9:59
 * @修改人：
 * @修改时间：2018/7/25 0025 9:59
 * @修改备注：
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;

        x.right = y;
        y.left = t3;

        //更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;

        x.left = y;
        y.right = t2;

        //更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    //判断该树是否是二分搜索树(满足二分搜索树的条件)
    public boolean isBST() {
        ArrayList<K> arrayList = new ArrayList<>();
        inOrder(root, arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1).compareTo(arrayList.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    //判断该二叉树是否是平衡二叉树
    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) return true;
        int balance = getBalanceFactor(node);
        if (Math.abs(balance) > 1) {
            return false;
        } else {
            return isBalance(node.left) && isBalance(node.right);
        }
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }


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
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
//        System.out.println("balanced = " + balanceFactor);
        //对当前平衡因子进行判断，如果平衡因子>1即平衡被破坏，需要平衡维护(旋转操作)。
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


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
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = removeNode(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = removeNode(node.right, key);
            retNode = node;
        } else { //相等 找到要删除的节点
            if (node.left == null) {
                //找到要删除的节点，并且该节点的左子树为null
                //将该节点的右节点 返回，即赋值给上一个节点左节点
                Node rightNode = node.right;
                node.right = null;
                size--;
//                return rightNode;
                retNode = rightNode;
            } else if (node.right == null) {
                //找到要删除的节点，并且该节点的右子树为null
                //将该节点的左节点 返回，即赋值给上一个节点右节点
                Node leftNode = node.left;
                node.left = null;
                size--;
//                return leftNode;
                retNode = leftNode;
            } else {
                //待删除节点的左右节点都不为null的情况。
                //1,找到该节点的右节点
                //2,找到右节点树下的最小节点(替换节点)(因为只有右子树下的最小节点和删除节点替换才不会影响树结构(二分搜索树满足条件)，也可以是左子树最大节点)
                //3,替换节点的右节点应该为 当前节点的右节点删除最小节点后的树(因为要和该节点替换所以要删除掉)
                //4,替换节点的左节点应该是当前节点的左子树
                //5,将当前节点的左右节点置为null
                Node rightNode = node.right;
                Node swapNode = miniNum(rightNode);
                swapNode.right = removeNode(rightNode, swapNode.key);
                swapNode.left = node.left;
                node.left = node.right = null;
//                return swapNode;
                retNode = swapNode;
            }
        }
        if (null == retNode) return null;
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        //对当前平衡因子进行判断，如果平衡因子>1即平衡被破坏，需要平衡维护(旋转操作)。
        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


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


    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (null == node) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = value;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
