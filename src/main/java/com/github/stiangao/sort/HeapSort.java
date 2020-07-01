package com.github.stiangao.sort;

import java.util.Arrays;

/**
 * @author shitiangao
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 4, 17, 42, 7, 1, 90, 65, 54};
        for (int i = 0; i < arr.length; i++) {
            heapSort(arr, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }
        int l = i * 2 + 1, r = l + 1;
        if (l < arr.length && arr[i] > arr[l]) {
            swap(arr, i, l);
        }
        if (r < arr.length && arr[i] > arr[r]) {
            swap(arr, i, r);
        }
        heapSort(arr, l);
        heapSort(arr, r);
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // n -> 2*n+1  2*n+2
    // i -> (i-1)/2
    private static void heapInsert(int[] arr, int i, int x) {
        int h = (i - 1) / 2;
        while (h > 0 && x < arr[h]) {
            arr[i] = arr[h];
            i = h;
            h = (i - 1) / 2;
            if (x > arr[h]) {
                arr[i] = x;
                return;
            }
        }
        if (x < arr[0]) {
            int a = arr[0];
            arr[0] = x;
            arr[i] = a;
        }

    }
}
