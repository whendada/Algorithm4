package com.whendada.algorithm.Unit2;

public class Merge extends SortExample {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(Comparable[] a, int low, int high) {
        //将数组 a[low...high] 排序
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        //将 a[low...mid] 和 a[mid+1...high]归并
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k < high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0] = "a";
        arr[1] = "d";
        arr[2] = "f";
        arr[3] = "s";
        arr[4] = "v";
        sort(arr);
    }
}
