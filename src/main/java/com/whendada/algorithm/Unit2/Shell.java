package com.whendada.algorithm.Unit2;

public class Shell extends SortExample {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = h*3 + 1;
        }
        //这是一个数一个数依次来的，而不是 第 0、4、8...一次性比完，例如 4-0，5-1、6-2、7-3、8-4、4-0...以此内推，这里的数都是数组的索引
        for (int i = h; i < N; i++) {
            //将 a[i] 插入到 a[i-h], a[i-2h], a[i-3h]...中
            for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                exchange(a, j, j-h);
            }
        }
    }
}
