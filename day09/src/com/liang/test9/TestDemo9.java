package com.liang.test9;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Day9 自定义异常实战
 *
 * 知识点回顾：
 * 1. 运行时异常（继承 RuntimeException）：编译时不报错，运行时才抛出
 *    受检异常（继承 Exception）：编译时就强制处理，必须 try-catch 或 throws
 * 2. throw：在方法体内主动抛出异常
 *    throws：在方法声明处告知调用方"我可能抛什么异常"
 * 3. 自定义异常 = 继承 RuntimeException（不强制处理）或 Exception（强制处理）
 */
public class TestDemo9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== 演示1：自定义运行时异常（ScoreException）=====
        // 用 while + try-catch 实现"输错了就重试"，直到合法才退出
        int score;
        while (true) {
            try {
                System.out.print("请输入分数（0~100）：");
                score = sc.nextInt();          // 输入字母会抛 InputMismatchException
                checkScore(score);             // 校验封装在方法里，非法时 throw 出来
                break;                         // 走到这说明分数合法，退出循环
            } catch (ScoreException e) {
                System.out.println("输入错误：" + e.getMessage() + "，请重新输入\n");
            } catch (InputMismatchException e) {
                System.out.println("只能输入数字，请重新输入\n");
                sc.nextLine();                 // 清掉残留的非法输入，否则会无限循环
            }
        }
        System.out.println("✅ 分数录入成功：" + score + "\n");

        // ===== 演示2：带业务错误码的异常（AgeException）=====
        int age;
        while (true) {
            try {
                System.out.print("请输入年龄（0~150）：");
                age = sc.nextInt();
                checkAge(age);
                break;
            } catch (AgeException e) {
                System.out.println("错误码 " + e.getCode() + "：" + e.getMessage() + "，请重新输入\n");
            } catch (InputMismatchException e) {
                System.out.println("只能输入数字，请重新输入\n");
                sc.nextLine();
            }
        }
        System.out.println("✅ 年龄录入成功：" + age + "\n");

        // ===== 演示3：受检异常 + throws（编译期强制处理）=====
        // UnderAgeException 继承 Exception，这里不 try-catch 根本编译不过
        try {
            register("小明", 17);   // 未满 18，抛 UnderAgeException
            register("小刚", 18);   // 满 18，正常
        } catch (UnderAgeException e) {
            System.out.println("❌ 注册失败：" + e.getMessage());
        }

        sc.close();
    }

    /** 校验分数：非法时抛出 ScoreException（throw 用在方法里） */
    private static void checkScore(int score) {
        if (score < 0 || score > 100) {
            throw new ScoreException("分数必须在 0~100 之间");
        }
    }

    /** 校验年龄：非法时抛出带错误码的 AgeException */
    private static void checkAge(int age) {
        if (age < 0 || age > 150) {
            throw new AgeException(400, "年龄必须在 0~150 之间");
        }
    }

    /**
     * 演示 throws：声明"这个方法可能抛 UnderAgeException"
     * 调用方（main）必须 try-catch，这是受检异常的强制要求
     */
    private static void register(String name, int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException(name + " 未成年（" + age + " 岁），不能注册");
        }
        System.out.println("✅ " + name + " 注册成功");
    }
}
