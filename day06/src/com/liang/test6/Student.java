package com.liang.test6;

import java.util.Arrays;

public class Student {
    private String sex;
    private int age;
    private String id;
    private String name;
    private int[] score;

    public Student() {
    }

    public Student(String sex, int age, String id, String name, int[] score) {
        this.sex = sex;
        this.age = age;
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getTotalScore() {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        return sum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "sex='" + sex + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + Arrays.toString(score) +
                '}';
    }
}
