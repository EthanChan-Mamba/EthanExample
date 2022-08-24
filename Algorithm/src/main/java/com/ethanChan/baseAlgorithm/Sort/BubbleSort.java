package com.ethanChan.baseAlgorithm.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName BubbleSort.java
 * @Description 冒泡排序
 * @createTime 2022-08-15 10:29
 */
public class BubbleSort {
    @Test
    public void sort() {
        int[] a = {3, 2, 1};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                System.out.println(Arrays.toString(a));
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
