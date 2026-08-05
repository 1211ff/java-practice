package com.liang.test1;

import java.util.Scanner;

/**
 * Day 1 练习：变量、基本类型、类型转换、键盘输入
 *
 * 基本数据类型（共 8 种）：
 *   byte 1B | short 2B | int 4B | long 8B
 *   float 4B | double 8B | char 2B | boolean（JVM 中一般 1B）
 * 注意：String 是引用类型，不是基本数据类型
 */
public class TestDemo1 {

    public static void main(String[] args) {
        // 1. 输入两个数求和
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个整数：");
        int num2 = sc.nextInt();
        System.out.println("两数之和 = " + (num1 + num2));

        // 2. 类型转换演示
        // 小范围 -> 大范围：自动转换（隐式）
        // 大范围 -> 小范围：必须强转，会丢失精度
        int intValue = 5;
        double doubleValue = 45.8;

        // double(8B) -> int(4B) 需要强转，45.8 被截断成 45
        intValue = (int) doubleValue;
        System.out.println("45.8 强转成 int = " + intValue);

        // int -> double 自动提升，不需要强转
        doubleValue = intValue;
        System.out.println("int 自动转成 double = " + doubleValue);

        sc.close();
    }
}
