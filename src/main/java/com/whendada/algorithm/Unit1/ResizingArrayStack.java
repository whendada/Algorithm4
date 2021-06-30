package com.whendada.algorithm.Unit1;

import java.util.Iterator;

/**
 * P88
 * 算法 1.1
 * 下压(LIFO)栈 (能动态调整数组的大小)
 */
public class ResizingArrayStack<Item> {

    // 栈元素
    private Item[] a = (Item[]) new Object[1];

    // 元素数量
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    // 将栈移动到大小为 max 的新数组
    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 将元素添加到栈顶
     */
    public void push(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    /**
     * 从栈顶删除元素
     */
    public Item pop() {
        Item item = a[--N];
        // 置空为了避免对象游离
        a[N] = null;
        //若已有元素数量小于数组的四分之一，则把数组容量减半
        if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * 迭代器,反序遍历
     */
    public Iterator<Item> iterator() {
        return new ReserveArrayIterator();
    }

    private class ReserveArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public static void main(String[] args) {

    }
}
