package com.whendada.algorithm.Unit3;

import com.whendada.algorithm.Unit1.Queue;

/**
 * 算法 3.2 二分查找（基于有序数组）
 * P 239
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;

    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        else {
            return null;
        }
    }

    /**
     *     // 递归实现
     *     public int rank(Key key, int low, int high) {
     *         if (high < low) {
     *             return low;
     *         }
     *         int mid = low + (high - low)/2;
     *         int cmp = key.compareTo(keys[mid]);
     *         if (cmp < 0) {
     *             return rank(key, low, mid -1);
     *         }
     *         else if (cmp > 0) {
     *             return rank(key, mid + 1, high);
     *         }
     *         return mid;
     *     }
     */

    public int rank(Key key) {
        int low = 0, high = N - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            }
            else if (cmp > 0) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return low;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N-1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new Queue<>();
        for (int i = rank(low); i < rank(high); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains)
    }
}
