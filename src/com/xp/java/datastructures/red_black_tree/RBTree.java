package com.xp.java.datastructures.red_black_tree;

/**
 * @类描述：红黑树 满足二分搜索树的性质 同时又有很多其他特性，为了更好理解，推荐先关注 2-3树
 * 二分搜索树 特点：左节点小于父节点，右节点大于父节点，所有的右节点都比左节点大。
 * <p>
 * 红黑树五大性质：
 * 1，节点是红色或者黑色
 * 2，根节点是黑色
 * 3，每个叶子节点(这里指的是最后的叶子节点下的null节点)都是黑色
 * 4，每个红色节点的两个子节点都是黑色。(从每个叶子到跟的所有路径上不能有两个连续的红色节点)
 * 5，从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点(因此红黑树也叫平衡B(black)树)
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 10:06
 * @修改人：
 * @修改时间：2018/7/27 0027 10:06
 * @修改备注：
 */
public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        this.root = null;
        this.size = 0;
    }

    private boolean isRed(Node node) {
        if (null == node) return BLACK;
        return node.color;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node) {
        Node x = node.right;

        //左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node) {
        Node x = node.left;

        //右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //如果一个节点的左右两个节点都为红色，说明这个节点在2-3树中是跟左右两个子树形成了一个暂时四节点，四节点然后进行分离，中间节点上浮。
    // 要上浮到上一个节点，并跟上一个节点形成一个三节点。所以这个时候这个节点应该是红色。
    //所以需要颜色翻转。将该节点标记为红色。两个子节点标记为黑色
    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(K key, V val) {
        root = add(root, key, val);
        root.color = BLACK; //红黑树条件之一 根节点为黑色
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

        //我们这里运行的红黑树其实具体可以成为左倾红黑树，因为红色节点只能在左边
        //因此如果我们发现红色节点在右侧。我们需要进行左旋转。将红色节点翻转到左侧。这个时候父节点其实就变了。
        //然后对旋转交换的两个节点颜色也进行交换
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        //如果该节点的左节点已经是红色了。我们可以理解为在2-3树种，父节点和左侧红节点是一个3树，下面有三个节点
        //如果在添加一个左侧红节点(没个节点进来默认红色)。我们认为是在2-3树的3树种有添加了一个节点。那么这个3树就变成了一个暂时的4树(红节点我们理解是和黑节点绑定的平衡关系)
        //这个时候暂时的4树是要进行分裂的，中间大小的节点上浮，其他两个节点作为他的子节点。这个时候其实就是一个右旋转过程。
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        //当右旋转过程完了以后会形成父节点是黑的。两个子节点是红色的情况。我们知道红色节点默认我们理解为适合黑的节点绑定平衡关系的。这个时候的的三个节点我们可以理解为还是一个4树。
        //根据2-3的绝对平衡规则，是不允许有4树存在的。这个时候我们进行颜色翻转，将父节点变为红色，子节点变为黑色。其实可以理解为。父节点上浮，
        // 父节点变成红色以后，可以理解为父节点和他的父节点建立和绑定关系，形成了一个3树，这样就消除了4树的存在，这就是颜色翻转的原因。
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }
        //以上三个条件是一个线性执行过程。而不是 if else互斥的执行过程。
        //我们发现 其实在第一个if 和  第二个if 执行完以后最终会满足第三个if。
        //对于红黑的几个节点情况。就那么几种，可以通过一个线性判断走到底，也可能跳过的中间的某个过程
        return node;
    }

    //红黑树的remove 暂时没有写。它更复杂一点，但是也跟插入的几种情况差不多。
    //后续我会补上代码
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
