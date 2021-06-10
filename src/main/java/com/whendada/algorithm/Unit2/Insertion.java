package com.whendada.algorithm.Unit2;

public class Insertion extends SortExample {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a, j,j-1);
            }
        }
    }
}
