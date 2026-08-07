package com.liang.test4;

import java.util.Arrays;
import java.util.Scanner;

/*
方法	作用	返回值
Arrays.toString(数组)	把数组转字符串，打印看内容	String
Arrays.sort(数组)	数组升序排序，直接修改原数组	void
Arrays.copyOf(原数组,新长度)	拷贝数组，生成新数组	数组
Arrays.copyOfRange(arr,from,to)	区间拷贝 [from , to)，to 不包含	数组
Arrays.fill(arr,值)	把数组全部元素填充同一个值	void
Arrays.equals(arr1,arr2)	比较两个数组内容是否完全一样	boolean
 */

public class TestDemo4 {
    public static void main(String[] args) {
        int size = 5;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[size];

        // 1. 输入 size 个数
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个数：");
            arr[i] = sc.nextInt();
        }

        System.out.println("=========== 你输入的内容 ===========");
        System.out.println(Arrays.toString(arr));

        // 2. 函数式遍历（Stream）
        System.out.println("=========== Stream 遍历 ===========");
        Arrays.stream(arr).forEach(System.out::println);

        // 3. 工具类排序
        Arrays.sort(arr);
        System.out.println("=========== Arrays.sort 升序 ===========");
        System.out.println(Arrays.toString(arr));

        // 4. 手动反转（方法只做反转，打印交给调用方）
        ArrayReverser reverser = new ArrayReverser();
        reverser.reverse(arr);
        System.out.println("=========== 反转后 ===========");
        System.out.println(Arrays.toString(arr));

        // 5. 手动冒泡排序（再排回升序）
        BubbleSort sorter = new BubbleSort();
        sorter.bubbleSort(arr);
        System.out.println("=========== 冒泡排序后 ===========");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}
