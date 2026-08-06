package com.liang.test2;

import java.util.Scanner;

/**
 * Day 2 练习：运算符、if/else if、switch、逻辑运算
 *
 * 知识点：
 *   1. 算术运算符：+ - * / %（整数除法会截断小数，% 取余数）
 *   2. 逻辑运算符：&&（与）、||（或）
 *   3. if / else if 分支结构
 *   4. switch 多分支选择
 */
public class TestDemo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ========== 1. 整数四则运算 + 取模 ==========
        System.out.println("整数 + - * / % 运算");
        System.out.print("请输入第一个整数：");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个整数：");
        int num2 = sc.nextInt();
        Calculator cal = new Calculator(num1, num2);
        cal.add();
        cal.sub();
        cal.mul();
        cal.div();
        System.out.println("=====================");

        // ========== 2. if/else if 成绩等级 ==========
        System.out.print("输入你的成绩：");
        int score = sc.nextInt();
        ScorePrinter sp = new ScorePrinter(score);
        sp.printGrade();
        System.out.println("=====================");

        // ========== 3. switch 简易菜单 ==========
        System.out.print("输入你要的功能（1=打印，2=保存，3=退出）：");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("打印");
                break;
            case 2:
                System.out.println("保存");
                break;
            case 3:
                System.out.println("退出");
                break;
            default:
                System.out.println("输入的数字有误，只能是 1、2、3");
        }
        System.out.println("=====================");

        // ========== 4. 判断闰年 ==========
        System.out.print("输入年份：");
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " 是闰年");
        } else {
            System.out.println(year + " 不是闰年");
        }

        sc.close();
    }
}

/**
 * 计算器类：封装两个整数的四则运算与取模
 */
class Calculator {
    int num1;
    int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void add() {
        System.out.println("加法：" + (num1 + num2));
    }

    public void sub() {
        System.out.println("减法：" + (num1 - num2));
    }

    public void mul() {
        System.out.println("乘法：" + (num1 * num2));
    }

    public void div() {
        // 除数不能为 0，否则程序会报 ArithmeticException 崩溃
        if (num2 == 0) {
            System.out.println("除法：除数不能为 0！");
        } else {
            System.out.println("除法：" + (num1 / num2) + " 余 " + (num1 % num2));
        }
    }
}

/**
 * 成绩等级类：根据分数输出对应等级
 */
class ScorePrinter {
    int score;

    public ScorePrinter(int score) {
        this.score = score;
    }

    public void printGrade() {
        if (score < 0 || score > 100) {
            System.out.println("输入有误，成绩应在 0~100 之间");
        } else if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 60) {
            System.out.println("合格");
        } else {
            System.out.println("不及格");
        }
    }
}
