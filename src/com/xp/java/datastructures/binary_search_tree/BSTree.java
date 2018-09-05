package com.xp.java.datastructures.binary_search_tree;

import com.xp.java.datastructures.stack_queues.queues.ArrayQueue;
import com.xp.java.datastructures.stack_queues.stack.ArrayStack;

/**
 * @类描述：二分搜索树 特点：左节点小于父节点，右节点大于父节点，所有的右节点都比左节点大。
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/25 0025 9:59
 * @修改人：
 * @修改时间：2018/7/25 0025 9:59
 * @修改备注：
 */
public class BSTree<T extends Comparable<T>> {
    public class Node {
        public T e;
        public Node left, right;

        public Node(T e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addNormal(T e) {
        if (null == root) {
            root = new Node(e);
            size++;
        }
        add(root, e);
    }

    public void addNormal(Node node, T e) {
        if (e.compareTo(node.e) == 0) {
            return;
        } else if (e.compareTo(node.e) < 0 && null == node.left) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && null == node.right) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            addNormal(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            addNormal(node.right, e);
        }
    }

    public void add(T e) {
        root = add(root, e);
    }

    public Node add(Node node, T e) {
        if (null == node) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(T e) {
        return contains(root, e);
    }

    private boolean contains(Node node, T e) {
        if (null == node) return false;
        if (e.equals(node.e)) return true;
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return false;
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的非递归前序遍历，基于栈的遍历
    // 这个写法对应 leetcode->Solution_0114题
    public void preOrderNR() {
        if (root == null) return;
        //用我们自己实现的数组栈，当然也可以用java自带的栈
        ArrayStack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            //既然是前序遍历，所以入栈的时候要先入右节点
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //二分搜索树的中序遍历,我们会发现中序遍历是有序的。
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历,一层一层从左到右
    //正常我们遍历一个查找一个树节点，他们复杂度应该为树的高 所以一般树的复杂度为 O(logn)
    //这个对应leetcode->Solution_0102
    public void levelOrder() {
        if (root == null) return;
        //用我们自己前面实现的队列
        ArrayQueue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.println(node.e);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    //找到二分搜索树中的最小元素
    public T getMiniNum() {
        return miniNum(root).e;
    }

    private Node miniNum(Node node) {
        if (node.left == null) return node;
        return miniNum(node.left);
    }

    //找到二分搜索树中的最小元素
    public T getMaxNum() {
        return maxNum(root).e;
    }

    private Node maxNum(Node node) {
        if (node.right == null) return node;
        return maxNum(node.right);
    }

    //删除最小元素所在的节点  并返回最小值
    public T removeMini() {
        T delMini = getMiniNum();
        root = removeMini(root);
        return delMini;
    }

    //删除最小节点，并返回新的树根
    private Node removeMini(Node node) {
        if (node.left == null) { //找到最小节点
            //下面是两部操作：
            // 1, 右节点为null，直接返回null 代表删除了最小节点
            // 2，右节点不为null 直接返回右节点，将该节点的右节点补位到删除节点位置(右节点补位，使得该树依然满足二分搜索树的规则)
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMini(node.left);
        return node;
    }

    //删除最大元素所在的节点 并返回最大值
    public T removeMax() {
        T delMax = getMaxNum();
        root = removeMax(root);
        return delMax;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树种删除元素为E的节点
    public void remove(T e) {
        root = remove(root, e);
    }

    private Node remove(Node node, T e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // 相等 找到要删除的节点
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
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder builder) {
        if (node == null) {
            builder.append(generateDepthString(depth) + "null\n");
            return;
        }
        builder.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, builder);
        generateBSTString(node.right, depth + 1, builder);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("- ");
        return res.toString();
    }
}
