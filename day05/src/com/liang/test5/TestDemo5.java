package com.liang.test5;

import java.util.Scanner;

/**
 * Day 5 练习：方法、参数校验、递归、数组求平均值
 *
 * 知识点：
 *   1. 方法封装：把一段逻辑抽成方法，通过参数传值、返回值取结果
 *   2. 参数校验：非法输入（负数、空数组）直接抛异常，而不是带病运行
 *   3. 整数除法陷阱：(double) sum / arr.length 才能得到小数，
 *      直接 sum / arr.length 是整数除法，小数部分被丢弃
 */
public class TestDemo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Factorial factorial = new Factorial();

        // 1. 阶乘（递归）
        System.out.print("请输入要计算阶乘的数：");
        int n = sc.nextInt();
        System.out.println(n + "! = " + factorial.fact(n));

        System.out.println("==============");

        // 2. 输入成绩数组
        System.out.print("请输入成绩个数：");
        int size = sc.nextInt();
        int[] scores = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个成绩：");
            scores[i] = sc.nextInt();
        }
        System.out.println("平均分 = " + getAverage(scores));

        sc.close();
    }

    /**
     * 计算数组的平均值
     *
     * @param arr 成绩数组
     * @return 平均分
     * @throws IllegalArgumentException 数组为空时抛出
     */
    public static double getAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        int sum = 0;
        for (int score : arr) {
            sum += score;
        }
        // 先转 double 再除，避免整数除法丢失小数
        return (double) sum / arr.length;
    }
}
