package com.liang.test7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 学生类：封装姓名和成绩，提供随机生成成绩、计算总分、平均分的方法
 */
public class Student {
    private String name;
    private int[] score;

    public Student() {
    }

    /**
     * 带参构造器：传入姓名和成绩个数，直接帮学生创建好成绩数组
     */
    public Student(String name, int length) {
        this.name = name;
        this.score = new int[length];
    }

    /**
     * 随机生成成绩（1~100），写入本对象的 score 数组
     */
    public void createRandomScore() {
        Random random = new Random();
        for (int i = 0; i < score.length; i++) {
            score[i] = random.nextInt(100) + 1;
        }
    }

    /**
     * 计算总分（增强 for 循环遍历）
     */
    public int sumScore() {
        int sum = 0;
        for (int j : score) {
            sum += j;
        }
        return sum;
    }

    /**
     * 计算平均分：全程 BigDecimal 运算，保留两位小数、四舍五入
     */
    public BigDecimal aveScore() {
        return new BigDecimal(sumScore())
                .divide(BigDecimal.valueOf(score.length), 2, RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
}
