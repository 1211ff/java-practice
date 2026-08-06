package com.liang.test3;

/**
 * Day 3 练习：循环结构（for / while）+ 多类协作
 *
 * 包含四个小练习：
 *   1. SumCalculator        1-100 偶数之和 / 奇数之和
 *   2. GuessGame            猜数字游戏（1-100）
 *   3. MultiplicationTable  99 乘法表（嵌套循环）
 *   4. PrimePrinter         0-100 的质数
 */
public class TestDemo3 {

    public static void main(String[] args) {
        // 1. 1-100 偶数、奇数之和
        SumCalculator sumCalculator = new SumCalculator(100);
        System.out.println("1-100 偶数之和 = " + sumCalculator.sumEvenNumbers());
        System.out.println("1-100 奇数之和 = " + sumCalculator.sumOddNumbers());

        // 2. 猜数字游戏
        System.out.println("猜数字游戏：");
        GuessGame guessGame = new GuessGame();
        guessGame.play();

        // 3. 99 乘法表
        System.out.println("99 乘法表：");
        MultiplicationTable table = new MultiplicationTable();
        table.print();

        // 4. 0-100 的质数
        System.out.println("0-100 的质数：");
        PrimePrinter primePrinter = new PrimePrinter(100);
        primePrinter.printPrimes();
    }
}
