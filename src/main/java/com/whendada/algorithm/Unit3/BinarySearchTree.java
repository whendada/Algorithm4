package com.whendada.algorithm.Unit3;

/**
 * 基于二叉查找树的符号表
 * P 252
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;

        private Value value;

        private Node left, right;

        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (null == x) {
            return 0;
        }
        else {
            return x.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        //在以x为根结点的子树中查找并返回 Key 对应的值，找不到则返回 null
        if (null == x) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }
        else if (cmp > 0) {
            return get(x.right, key);
        }
        else {
            return x.value;
        }
    }

    public void put(Key key, Value value) {
        //查找 key，找到则更新，否则创建一个新的值
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (null == x) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (null == x.left) {
            return x;
        }
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (null == x) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (null == x) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (null != t) {
            return t;
        }
        return x;
    }
}
