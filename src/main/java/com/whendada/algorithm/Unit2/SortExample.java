package com.whendada.algorithm.Unit2;

/**
 * P153
 * 排序算法类的模版
 */
public class SortExample {

    public static void sort(Comparable[] a) {

    }

    /**
     * v < w , -1;
     * v = w , 0;
     * v > w , 1;
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 测试数组是否有序
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
