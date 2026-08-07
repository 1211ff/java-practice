package com.liang.test4;

/**
 * 数组反转器：把数组元素顺序颠倒
 * 注意：数组是引用类型，方法里直接修改的是原数组
 */
public class ArrayReverser {
    public void reverse(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
