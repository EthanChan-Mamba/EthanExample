package com.ethanChan.baseAlgorithm.Sort;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SelectionSort.java
 * @Description TODO
 * @createTime 2022-08-16 16:25
 */
public class SelectionSort {

    public static void main(String[] args) {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        selectSort(a, a.length);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }

    private static void selectSort(int[] a, int length) {
        for (int i = 0; i < length - 1; i++) {
            // 最小值下标
            int index = i;
            // 1. 找出右边最小值
            for (int j = i + 1; j < length; j++) {
                // 1.1 记录最小值下标
                if (a[index] > a[j]) {
                    index = j;
                }
            }
            // 2. 将当前元素和最小值互换
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }
}
