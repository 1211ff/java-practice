package com.liang.test4;

/**
 * 冒泡排序：每轮把相邻较大的元素往后"冒"，多轮后整体升序
 * 直接修改传入的原数组，不返回新数组
 */
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
