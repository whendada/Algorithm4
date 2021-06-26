package com.whendada.algorithm.Unit3;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺序查找（基于无序链表）
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {

        Key key;

        Value val;

        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public int size() {
        int count = 0;
        if (first == null) {
            return 0;
        }
        for (Node x = first; x != null; x = x.next) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
