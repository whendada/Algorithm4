package com.whendada.algorithm.Unit1;

/**
 * P95
 * 队列 (链表实现)
 */
public class Queue<Item> {

    private Node first;

    private Node last;

    // 队列中的元素数量
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
        /**
         * 或者 N == 0，N == 0是错的，如果队列只有一个元素，出队之后 first 和 last 应该是空，而 N == 0
         * 的判断是在出队 N-- 之前，此时 N = 1。
         */
    }

    public int size() {
        return N;
    }

    /**
     * 从表尾插入元素
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        //这里的判空是判断插入之前的队列是否为空
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * 从表头删除元素,这里假定本来队列还有元素
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        --N;
        if (isEmpty()) {
            last = null;
        }
        return item;

        // 这里的判空是出队之后的队列是否为空，所以用 N == 0 不准确，因为 --N 在后面，把 --N 放前面即可，优化如上
//        if (isEmpty()) {
//            last = null;
//        }
//        --N;
//        return item;
//    }
    }
}
