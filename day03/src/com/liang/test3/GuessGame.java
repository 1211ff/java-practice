package com.liang.test3;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜数字游戏：程序随机生成 1-100 的数字，玩家不断猜测直到猜中
 *
 * 知识点：
 *   - Random 随机数
 *   - while(true) 无限循环 + break 退出
 *   - this.target 区分成员变量和局部变量（你原来代码里 this.count 的写法，思路是对的）
 */
public class GuessGame {

    private final int target;              // 成员变量：要猜的目标数字
    private final Scanner sc = new Scanner(System.in);

    public GuessGame() {
        target = new Random().nextInt(100) + 1;   // 生成 1-100 的随机数
    }

    public void play() {
        while (true) {
            System.out.print("请输入你猜的数字（1-100）：");
            int input = sc.nextInt();             // 局部变量：玩家输入

            if (input > target) {
                System.out.println("数字大了，再试试");
            } else if (input == target) {
                System.out.println("恭喜，猜对了！");
                break;
            } else {
                System.out.println("数字小了，再试试");
            }
        }
        sc.close();
    }
}
