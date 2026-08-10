package com.liang.test7;

public class TestDemo7 {
    public static void main(String[] args) {
        // 每个学生各自 new 自己的成绩数组，互不干扰
        Student s1 = new Student("小明", 5);
        Student s2 = new Student("小王", 5);
        Student s3 = new Student("小白", 5);

        s1.createRandomScore();
        printStudent(s1);
        System.out.println("===================");
        s2.createRandomScore();
        printStudent(s2);
        System.out.println("===================");
        s3.createRandomScore();
        printStudent(s3);
    }

    /**
     * 打印学生的成绩、总分、平均分（打印职责集中在这里）
     */
    private static void printStudent(Student s) {
        int[] score = s.getScore();
        for (int i = 0; i < score.length; i++) {
            System.out.println(s.getName() + "的第" + (i + 1) + "个分数：" + score[i]);
        }
        System.out.println("总分为：" + s.sumScore());
        System.out.println("平均分为：" + s.aveScore());
    }
}
