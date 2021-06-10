package com.whendada.algorithm.Unit1;

/**
 * P94
 * 下压堆栈 (链表实现)
 */
public class Stack<Item> {

    // 栈顶(最近添加的元素)
    private Node first;

    // 元素数量
    private int N;

    // 定义节点的嵌套类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
        //或者 return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * 向栈顶添加元素
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 从栈顶删除元素
     */
    public Item pop() {
        Item item = first.item;
        first = first.next; //原来的first节点成了孤儿节点，会被自动回收
        --N;
        return item;
    }


}
