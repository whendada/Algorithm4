package com.whendada.algorithm.Unit2;

/**
 * P156
 * 选择排序
 */
public class Selection extends SortExample {

    public static void sort(Comparable[] a) {
        //将 a 按照升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    exchange(a, i, min);
                }
            }
        }
    }
}
